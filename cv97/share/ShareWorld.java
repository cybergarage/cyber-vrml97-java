/******************************************************************
*
*	CyberVRML97 for Java3D
*
*	Copyright (C) Satoshi Konno 1997-2000
*
*	File:	ShareWorld.java
*
******************************************************************/

package cv97.share;

import java.io.*;
import java.net.*;

import cv97.*;
import cv97.util.*;

public abstract class ShareWorld implements Runnable, ShareWorldThread
{
	public ShareWorld()
	{
		setSceneGraph(null);
		setThreadExecuteFlag(false);
	}
	
	public ShareWorld(SceneGraph sg)
	{
		this();
		setSceneGraph(sg);
	}

	////////////////////////////////////////////////
	//	Port
	////////////////////////////////////////////////
	
	private static final int defaultServerSocketPort	= 7003;
	
	public static int getDefaultSeverSocketPort()
	{
		return defaultServerSocketPort;
	}

	////////////////////////////////////////////////
	//	SceneGraph
	////////////////////////////////////////////////
	
	private SceneGraph mSceneGraph;
	
	public void setSceneGraph(SceneGraph sg)
	{
		mSceneGraph = sg;
	}
	
	public SceneGraph getSceneGraph()
	{
		return mSceneGraph;
	}
	
	public boolean hasSceneGraph()
	{
		return (mSceneGraph != null) ? true : false;
	}

	////////////////////////////////////////////////
	//	Thread (Execute Flag)
	////////////////////////////////////////////////

	private Boolean	mThreadExecuteFlag	= new Boolean(false);

	private void setThreadExecuteFlag(boolean flag)
	{
		synchronized (mThreadExecuteFlag)
		{
			mThreadExecuteFlag = new Boolean(flag);
		}
	}

	private boolean isThreadExecuting()
	{
		boolean flag = false;
		synchronized (mThreadExecuteFlag)
		{
			flag = mThreadExecuteFlag.booleanValue();
		}
		return flag;
	}
	
	////////////////////////////////////////////////
	//	Thread
	////////////////////////////////////////////////

	public void executeThread() 
	{
		Debug.message("executeThread");
		
		setThreadExecuteFlag(true);
		
		Thread clientThread = new Thread(this);

		Debug.message("  clientThread = " + clientThread);
		
		clientThread.start();

		Debug.message("  start");
	}

	public void stopThread() 
	{
		setThreadExecuteFlag(false);
	}

	public void run()
	{
		while (isThreadExecuting() == true)
		{
			execute();
		}
	}
}
