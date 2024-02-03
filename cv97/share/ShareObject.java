/******************************************************************
*
*	CyberVRML97 for Java3D
*
*	Copyright (C) Satoshi Konno 1997-2000 
*Å@
*	File:	ShareObject.java
*
******************************************************************/

package cv97.share;

import java.io.*;

import cv97.*;

public abstract class ShareObject implements Serializable
{
	///////////////////////////////////////////////
	// Constractor
	///////////////////////////////////////////////
	
	public ShareObject()
	{
	}
	
	public abstract boolean writeData(ObjectOutputStream out) throws IOException;
	public abstract boolean readData(ObjectInputStream in) throws IOException, ClassNotFoundException;
	
	public abstract boolean update(SceneGraph sg);
}
