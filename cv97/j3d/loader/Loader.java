/******************************************************************
*
*	VRML97Saver for CyberVRML97
*
*	Copyright (C) Satoshi Konno 1999
*
*	File:	VRML97Loader.java
*
******************************************************************/

package cv97.j3d.loader;

import java.io.*;
import java.net.*;
import javax.media.j3d.*;

import cv97.*;
import cv97.SceneGraph;
import cv97.node.*;
import cv97.j3d.*;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.LoaderBase;

public abstract class Loader extends LoaderBase
{
	///////////////////////////////////////////////
	// Constructor
	///////////////////////////////////////////////

	public Loader() 
	{
		SceneGraph sg = getSceneGraph();
		SceneGraphJ3dObject sgObject = new SceneGraphJ3dObject(sg);
		sg.setObject(sgObject);		
	}

	public Loader(Canvas3D canvas3D)
	{
		SceneGraph sg = getSceneGraph();
		SceneGraphJ3dObject sgObject = new SceneGraphJ3dObject(canvas3D, sg, false);
		sg.setObject(sgObject);
		sgObject.removeBranchGroup();	
	}


	///////////////////////////////////////////////
	// SceneGraph
	///////////////////////////////////////////////

	private SceneGraph sg = new SceneGraph();
	
	public SceneGraph getSceneGraph()
	{
		return sg;
	}
	
	///////////////////////////////////////////////
	// BranchGroup/Scene
	///////////////////////////////////////////////

	public BranchGroup getBranchGroup() 
	{
		SceneGraph sg = getSceneGraph();
		SceneGraphJ3dObject sgObj = (SceneGraphJ3dObject)sg.getObject();
		return sgObj.getBranchGroup();
	}

	public Scene getScene() 
	{
		SceneBase sceneBase = new SceneBase();
		BranchGroup bg = getBranchGroup();
		sceneBase.setSceneGroup(bg);
		return sceneBase;
	}

	///////////////////////////////////////////////
	// load
	///////////////////////////////////////////////

	public Scene load(Reader reader)
	{
		return null;
	}
	
	public Scene load(String fileName)
	{
		SceneGraph sg = getSceneGraph();
		sg.load(fileName);
		return getScene();	
	}
	
	public Scene load(URL url)
	{
		SceneGraph sg = getSceneGraph();
		sg.load(url);
		return getScene();	
	}
}
