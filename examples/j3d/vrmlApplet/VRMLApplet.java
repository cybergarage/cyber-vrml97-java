/******************************************************************
*
*	VRML Applet Viewer for Java3D
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

import javax.media.j3d.*;

import cv97.*;
import cv97.j3d.*;
import cv97.node.*;
import cv97.node.Node;
import cv97.field.*;
import cv97.util.*;

public class VRMLApplet extends Applet implements Constants, MouseListener, MouseMotionListener, Runnable {

	private VRMLCoreJ3D vrmlCore = new VRMLCoreJ3D();
	private Thread mThread = null;

	public SceneGraph getSceneGraph() {
		return vrmlCore.getSceneGraph();
	}

	////////////////////////////////////////////////
	// init
	////////////////////////////////////////////////

	public void init()
	{
		Canvas3D c = vrmlCore.getCanvas3D();
		setLayout(new BorderLayout());
		add("Center", c);

		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
		enableEvents(AWTEvent.KEY_EVENT_MASK);
		
		c.addMouseListener(this);
		c.addMouseMotionListener(this);

		String srcParam = getParameter("src");
		Debug.message(" src = " + srcParam);
		
		loadSceneGraph(srcParam);
	
		startSimulation();
	}

	////////////////////////////////////////////////
	// Thread
	////////////////////////////////////////////////

	public void startSimulation() 
	{
		vrmlCore.startSimulation();
		if (mThread == null) {
			mThread = new Thread(this);
			mThread.start();
		}
	}

	public void stopSimulation() 
	{
		vrmlCore.stopSimulation();
		if (mThread != null) {
			mThread.stop();
			mThread = null;
		}
	}

	public void updateViewpoint() 
	{
		int width = getWidth();
		int height = getHeight();
		vrmlCore.updateViewpoint(width, height);
	}

	public void run() 
	{
		while (true) {
			updateViewpoint();
			repaint();
			//Thread.yield();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}

	////////////////////////////////////////////////
	//	mouse
	////////////////////////////////////////////////

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		vrmlCore.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		vrmlCore.mouseReleased(e);
	}

	public void mouseDragged(MouseEvent e) {
		vrmlCore.mouseDragged(e);
	}

	public void mouseMoved(MouseEvent e) {
		vrmlCore.mouseMoved(e);
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
		
		sg.initialize();
	}


}
