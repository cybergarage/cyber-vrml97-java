/******************************************************************
*
*	Simple VRML Applet Viewer for Java3D
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File:	VRMLApplet.java
*
******************************************************************/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import cv97.*;
import cv97.node.*;
import cv97.node.Node;
import cv97.field.*;
import cv97.util.*;

public class VRMLApplet extends Applet implements Constants, Runnable, KeyListener {

	private SceneGraph				mSceneGraph			= null;					
	private Thread					mThread				= null;

	public SceneGraph getSceneGraph() {
		return mSceneGraph;
	}

	////////////////////////////////////////////////
	// init
	////////////////////////////////////////////////

	public void init()
	{
		Debug.on();
		Debug.message("VRMLApplet::init");
		
		mSceneGraph = new SceneGraph();

		String srcParam = getParameter("src");
		Debug.message(" src = " + srcParam);
		
		loadSceneGraph(srcParam);
		
		addKeyListener(this);
	}

	public void start() {
	}

	public void stop() {
	}

	public void run() 
	{
	}

	////////////////////////////////////////////////
	// paint/update
	////////////////////////////////////////////////

	private int frameMaxCnt = 120;
	private int frameCnt = 0;
	private long frameTime = 0;
	
	public void paint(Graphics g)
	{
		SceneGraph sg = getSceneGraph();

		long stime = System.currentTimeMillis();
				
		sg.updateSimulation();
		
		Graphics offGraph = lockScreen(g);
		drawSceneGraph(sg, offGraph);
		unlockScreen(g);
		
		long etime = System.currentTimeMillis();
		frameTime += etime - stime;
		frameCnt++;
		
		if (frameMaxCnt < frameCnt) {
			float frameRate = 1.0f / (((float)frameTime/1000.0f) / (float)frameCnt);
			setFrameRate(frameRate);
			frameTime = 0;
			frameCnt = 0;
			printInfo();
		}
		
		repaint();
	}

	public void update(Graphics g)
	{
		paint(g);
	}

	////////////////////////////////////////////////
	// Simulation Mode
	////////////////////////////////////////////////

	public static final int RENDERING_NONE = 0;
	public static final int RENDERING_WIRE = 1;
	public static final int RENDERING_FLAT = 2;
	
	private int renderingMode = RENDERING_FLAT;
	
	void setRenderingMode(int mode)
	{
		renderingMode = mode;
	}

	int getRenderingMode()
	{
		return renderingMode;
	}
	
	////////////////////////////////////////////////
	// ScreenLock/Unlock
	////////////////////////////////////////////////

	private Image offScrImage = null;
	private Graphics offScrGraphics = null;
	private int offScrImageSize[] = new int[2];
	
	private Graphics lockScreen(Graphics g)
	{
		int currWidth = getWidth();
		int currHeight = getHeight();
		
		if (offScrImage == null || currWidth != offScrImageSize[0] || currHeight != offScrImageSize[1]) {
			offScrImage = createImage(currWidth, currHeight);
			offScrGraphics = offScrImage.getGraphics();	
			offScrImageSize[0] = currWidth;
			offScrImageSize[1] = currHeight;
		} 
		
		return offScrGraphics;
	}

	private void unlockScreen(Graphics g)
	{
		g.drawImage(offScrImage, 0, 0, this);
	}

	////////////////////////////////////////////////
	// Performance
	////////////////////////////////////////////////

	private float frameRate = 0;
	
	private int getNPolygons()
	{
		return 104;
	}

	private void setFrameRate(float rate)
	{
		frameRate = rate;
	}

	private float getFrameRate()
	{
		return frameRate;
	}
		
	////////////////////////////////////////////////
	// loadScengraph
	////////////////////////////////////////////////

	private void loadSceneGraph(String modelName)
	{
		SceneGraph sg = getSceneGraph();

		try {	
			URL modelUrl = new URL(modelName);
			sg.load(modelUrl);
		} catch (MalformedURLException e) {
			Debug.warning(e.getMessage());
		};
		
/*		
		ShapeNode shape = new ShapeNode();
		BoxNode box = new BoxNode();
		box.setSize(2, 2, 2);
		
		sg.addNode(shape);
		shape.addChildNode(box);
*/		
		sg.initialize();
	}

	////////////////////////////////////////////////
	// drawSceneGraph
	////////////////////////////////////////////////

	private float viewMat[][] = new float[4][4];
	private float bgCol[] = new float[3];
	
	private void drawSceneGraph(SceneGraph sg, Graphics g)
	{
		int gWidth = getWidth();
		int gHeight = getHeight();
		
		////////////////////////////////////////		
		// Background Node
		////////////////////////////////////////		
		
		Color bgColor = new Color(0.0f, 0.0f, 0.0f);
	
		BackgroundNode bg = sg.getBackgroundNode();
		if (bg != null) {
			if (0 < bg.getNSkyColors()) {
				bg.getSkyColor(0, bgCol);
				bgColor = new Color(bgCol[0], bgCol[1], bgCol[2]);
			}
		}
		
		g.setColor(bgColor);
		g.fillRect(0, 0, gWidth, gHeight);

		////////////////////////////////////////		
		// Viewpoint Node
		////////////////////////////////////////		
		
		////////////////////////////////////////		
		// Viewpoint Node
		////////////////////////////////////////		
		
		ViewpointNode view = sg.getViewpointNode();
		if (view == null)
			view = sg.getDefaultViewpointNode();

		view.getMatrix(viewMat);
		SFMatrix viewMx = new SFMatrix(viewMat);

		////////////////////////////////////////		
		// drawNode
		////////////////////////////////////////		
		
		drawNode(sg, g, viewMx, sg.getNodes());
	}

	////////////////////////////////////////////////
	// drawNode
	////////////////////////////////////////////////

	private void drawNode(SceneGraph sg, Graphics g, SFMatrix viewMx, Node firstNode)
	{
		if (firstNode == null)
			return;

		Node node;

/*
		for (node = firstNode; node != null; node=node.next()) {
			if (node.isLightNode()) 
				PushLightNode((LightNode)node);
		}
*/

		for (node = firstNode; node != null; node=node.next()) {
			if (node.isShapeNode()) 
				drawShapeNode(sg, g, viewMx, (ShapeNode)node);
			else
				drawNode(sg, g, viewMx, node.getChildNodes());
		}

/*
		for (node = firstNode; node != null; node=node.next()) {
			if (node.isLightNode()) 
				PopLightNode((LightNode)node);
		}
*/
	}

	////////////////////////////////////////////////
	// drawNode
	////////////////////////////////////////////////

	private float objMat[][] = new float[4][4];

	private void drawShapeNode(SceneGraph sg, Graphics g, SFMatrix viewMx, ShapeNode shapeNode)
	{
		/////////////////////////////////
		// Transform
		/////////////////////////////////
	
		shapeNode.getTransformMatrix(objMat);
		SFMatrix objMx = new SFMatrix(objMat);

		/////////////////////////////////
		// Color
		/////////////////////////////////
		

		/////////////////////////////////
		// Geometry
		/////////////////////////////////

		GeometryNode geomNode = shapeNode.getGeometryNode();
		if (geomNode == null)
			return;

		if (geomNode.isBoxNode() == true)
			drawBoxNode(g, viewMx, objMx, (BoxNode)geomNode);
		if (geomNode.isIndexedFaceSetNode() == true)
			drawIdxFaceSetNode(g, viewMx, objMx, (IndexedFaceSetNode)geomNode);
	}

	////////////////////////////////////////////////
	// drawPolygon
	////////////////////////////////////////////////

	private float hither = 0.1f;
	private float winScale = 10000.0f;

	Color geomColor = new Color(1.0f, 1.0f, 1.0f);
    	
	boolean isClippingPolygon(int dx[], int dy[])
	{
		int flag = (dx[1] - dx[0])*(dy[2] - dy[1])-(dx[2] - dx[1])*(dy[1] - dy[0]);
		if(flag < 0)
			return true;
		return false;
	}

	private void drawPolygon(Graphics g, SFMatrix viewMx, SFMatrix objMx, Polygon3D poly, int rederingMode)
	{
		float v[] = new float[3];
		
		int nPoints = poly.npoints;	
		
		int dx[] = new int[nPoints];
		int dy[] = new int[nPoints];
		
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;

	    for (int n = 0; n < nPoints; n++) {
	    	poly.get(n, v);
	    	
	    	objMx.multi(v);
	    	viewMx.multi(v);

	   		float dz = -v[2];
	   		if (dz <= hither)
	   			continue;

	   		dx[n] = (int)((hither * v[0]) / (v[2] + hither) * winScale) + cx;
	   		dy[n] = (int)((hither * v[1]) / (v[2] + hither) * winScale) + cy;
	   		
	   		if (n == 2) {
	   			if (isClippingPolygon(dx, dy) == true)
	   				return;
	   		}
	    }

		if (rederingMode == RENDERING_NONE)
			return;
			
	    Color polyColor = new Color(poly.color[0], poly.color[1], poly.color[2]);
		g.setColor(polyColor);
			    
		switch (renderingMode) {
		case RENDERING_WIRE:
			{
	    		g.drawPolygon(dx, dy, nPoints);
			}
			break;
		case RENDERING_FLAT:
			{
		    	g.fillPolygon(dx, dy, nPoints);
			}
			break;
		}
    }

	private void drawPolygonList(Graphics g, SFMatrix viewMx, SFMatrix objMx, Polygon3DList polyList, int renderingMode)
	{
		int nPolys = polyList.size();
		for (int n=0; n<nPolys; n++)
			drawPolygon(g, viewMx, objMx, polyList.getPolygon(n), renderingMode);
	}

	////////////////////////////////////////////////
	// setPolygonColors
	////////////////////////////////////////////////

    float lightPos[] = {50.0f, 10.0f, 100.0f};
	float ambIntensity = 0.1f;

	private float addIntensity(float currValue, float addValue) 
	{
		float value = currValue + addValue;
		if (value > 1.0f)
			value = 1.0f;
		else if (value < 0.0f)
			value = 0.0f;
		return value;
	}

   	float polyPos[] = new float[3];
   	float polyNorm[] = new float[3];
   	float lightNorm[] = new float[3];
   	
	private void setPolygon3DColor(GeometryNode geomNode, SFMatrix objMx, Polygon3D poly)
	{
    	// Color
		float polyColor[] = {1.0f, 1.0f, 1.0f};
		poly.getNormal(polyNorm);
    	objMx.multi(polyNorm);
		poly.getMidPos(polyPos);
    	objMx.multi(polyPos);
		Math3D.dir(polyPos, lightPos, lightNorm);
		float intensity = Render3D.getLambertIntensity(polyNorm, lightNorm);
		intensity = addIntensity(intensity, ambIntensity);
//System.out.println("intensity = " + intensity);
		Render3D.getLambertColor(polyColor, intensity);
		poly.setColor(polyColor);
	}
		    
	private void setPolygon3DColors(GeometryNode geomNode, SFMatrix objMx, Polygon3DList polyList)
	{
		int nPolys = polyList.size();
		for (int n=0; n<nPolys; n++) {
			Polygon3D poly = polyList.getPolygon(n);
			setPolygon3DColor(geomNode, objMx, poly);
	    }
	}
    
	////////////////////////////////////////////////
	// drawBox
	////////////////////////////////////////////////

    private float boxNorm[][] = {
			{0.0f, 0.0f, 1.0f}, {0.0f, -1.0f, 0.0f}, {0.0f, 0.0f, 1.0f},
			{0.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f}, {-1.0f, 0.0f, 0.0f}};

	private int boxFaces[][] = {
			{ 3, 2, 1, 0 }, { 7, 6, 2, 3 }, { 4, 5, 6, 7 },
			{ 0, 1, 5, 4 }, { 1, 2, 6, 5 }, { 3, 0, 4, 7 }};

	private float boxTexCoord[][] = {
			{ 0.0f, 1.0f }, { 1.0f, 1.0f },
			{ 1.0f, 0.0f }, { 0.0f, 0.0f } };

	private float boxVertex[][] = new float[8][3];

	private Polygon3DList getPolygon3DList(BoxNode boxNode)
	{
		float bx = boxNode.getX();
		float by = boxNode.getY();
		float bz = boxNode.getZ();
		 
		float x0 = -bx / 2.0f;
		float x1 =  bx / 2.0f;
		float y0 = -by / 2.0f;
		float y1 =  by / 2.0f;
		float z0 = -bz / 2.0f;
		float z1 =  bz / 2.0f;

		boxVertex[0][0] = boxVertex[3][0] = boxVertex[4][0] = boxVertex[7][0] = x0;
		boxVertex[1][0] = boxVertex[2][0] = boxVertex[5][0] = boxVertex[6][0] = x1;
		boxVertex[2][1] = boxVertex[3][1] = boxVertex[6][1] = boxVertex[7][1] = y0;
		boxVertex[0][1] = boxVertex[1][1] = boxVertex[4][1] = boxVertex[5][1] = y1;
		boxVertex[4][2] = boxVertex[5][2] = boxVertex[6][2] = boxVertex[7][2] = z0;
		boxVertex[0][2] = boxVertex[1][2] = boxVertex[2][2] = boxVertex[3][2] = z1;

		Polygon3DList polyList = new Polygon3DList();
		
	    for (int i = 0; i < 6; i++) {
			Polygon3D poly = new Polygon3D(5);
		    for (int j = 0; j < 5; j++) {
		    	poly.pos[j][0] = boxVertex[boxFaces[i][j%4]][0];
		    	poly.pos[j][1] = boxVertex[boxFaces[i][j%4]][1];
		    	poly.pos[j][2] = boxVertex[boxFaces[i][j%4]][2];
	    	}
	    	polyList.add(poly);
	    }
	    
	    return polyList;
	}
	 
	private void drawBoxNode(Graphics g, SFMatrix viewMx, SFMatrix objMx, BoxNode boxNode)
	{
		Polygon3DList polyList = getPolygon3DList(boxNode);
		setPolygon3DColors(boxNode, objMx, polyList);
		drawPolygonList(g, viewMx, objMx, polyList, getRenderingMode());
    }
	
	////////////////////////////////////////////////
	// drawIdxFaceSetNode
	////////////////////////////////////////////////

	private static int POLY_IDX_MAX = 1024;
	private int polyCoordIdx[] = new int[POLY_IDX_MAX];

	private Polygon3DList getPolygon3DList(IndexedFaceSetNode idxNode)
	{
		Polygon3DList polyList = new Polygon3DList();
		
		CoordinateNode coordNode = idxNode.getCoordinateNodes();
		if (coordNode == null)
			return polyList;
			
		int nCoordIndices = idxNode.getNCoordIndices();
		if (nCoordIndices <= 0)
			return polyList;

		float point[] = new float[3];
		int polyCoordIdxCnt = 0;
		for (int n=0; n<nCoordIndices; n++) {
			int id = idxNode.getCoordIndex(n);
			if (id != -1)
				polyCoordIdx[polyCoordIdxCnt++] = id;
			if (id == -1 || n == (nCoordIndices-1)) {
				Polygon3D poly = new Polygon3D(polyCoordIdxCnt);
				for (int i=0; i<polyCoordIdxCnt; i++) 
					coordNode.getPoint(polyCoordIdx[i], poly.pos[i]);
		    	polyList.add(poly);
				polyCoordIdxCnt = 0;
			}
		}

	    return polyList;
	}
		
	private void drawIdxFaceSetNode(Graphics g, SFMatrix viewMx, SFMatrix objMx, IndexedFaceSetNode idxNode)
	{
		Polygon3DList polyList = getPolygon3DList(idxNode);
		setPolygon3DColors(idxNode, objMx, polyList);
		drawPolygonList(g, viewMx, objMx, polyList, getRenderingMode());
	}
	
	////////////////////////////////////////////////
	//	Viewpoint
	////////////////////////////////////////////////

	private float getNavigationSpeed()
	{
		return 0.1f;
	}

	private float getNavigationRotationSpeed()
	{
		return 0.01f;
	}
		
	public void updateViewpoint(int mx, int my) {

		SceneGraph sg = getSceneGraph();
		if (sg == null)
			return;

		float width2 = (float)getWidth() / 2.0f;
		float height2 = (float)getHeight() /2.0f;

		float	vector[] = {0, 0, 0};
		float	yrot = 0.0f;

		float navSpeed = getNavigationSpeed();			
		float navRotSpeed = getNavigationRotationSpeed();			
		
		vector[Z] = (((float)my - height2) / height2) * navSpeed;
		yrot = -(((float)mx - width2) / width2 * navRotSpeed);

		// update viewpoint position
		ViewpointNode view = sg.getViewpointNode();
		if (view == null)
			view = sg.getDefaultViewpointNode();
		float viewOrienataion[] = new float[4];
		viewOrienataion[0] = 0.0f;
		viewOrienataion[1] = 1.0f;
		viewOrienataion[2] = 0.0f;
		viewOrienataion[3] = yrot;
		view.addOrientation(viewOrienataion);

		float viewFrame[][] = new float[3][3];
		view.getFrame(viewFrame);
		for (int n=X; n<=Z; n++) {
			viewFrame[n][X] *= vector[n];
			viewFrame[n][Y] *= vector[n];
			viewFrame[n][Z] *= vector[n];
			view.addPosition(viewFrame[n]);
		}
		
		view.getPosition(vector);
		//System.out.println("viewpos = " + vector[0] + ", " + vector[1] + ", " + vector[1]);
	}

	/////////////////////////////////
	//	Key Listner
	/////////////////////////////////

	private void printInfo()
	{
		SceneGraph sg = getSceneGraph();

		System.out.println("==== SceneGrpah Infomation ====");
		System.out.println("  polys     = " + getNPolygons());
		System.out.println("  frameRate = " + getFrameRate());
		System.out.println("  polys/sec = " + (int)(getFrameRate()*getNPolygons()));
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		int width = getWidth();
		int height = getHeight();
		int width2 = width / 2;
		int height2 = height / 2;

		System.out.println("Pressed Key = " + e.getKeyChar());
			
		switch (keyCode) {
		case KeyEvent.VK_I:
			{
				printInfo();
			}
			break;
		case KeyEvent.VK_4:
			{
				updateViewpoint(width, height2);			
				repaint();
			}
			break;
		case KeyEvent.VK_6:
			{
				updateViewpoint(0, height2);
				repaint();
			}
		case KeyEvent.VK_8:
			{
				updateViewpoint(width2, 0);			
				repaint();
			}
			break;
		case KeyEvent.VK_2:
			{
				updateViewpoint(width2, height);			
				repaint();
			}
			break;
		case KeyEvent.VK_N:
			{
				setRenderingMode(RENDERING_NONE);
				repaint();
			}
			break;
		case KeyEvent.VK_F:
			{
				setRenderingMode(RENDERING_FLAT);
				repaint();
			}
			break;
		case KeyEvent.VK_W:
			{
				setRenderingMode(RENDERING_WIRE);
				repaint();
			}
			break;
		}


	}

	public void keyReleased(KeyEvent e) 
	{
	}

	public void keyTyped(KeyEvent e)
	{
	}
}
