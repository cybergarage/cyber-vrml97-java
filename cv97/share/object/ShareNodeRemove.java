/******************************************************************
*
*	CyberVRML97 for Java3D
*
*	Copyright (C) Satoshi Konno 1997-2000 
*�@
*	File:	ShareNodeRemove.java
*
******************************************************************/

package cv97.share.object;

import java.io.*;

import cv97.*;
import cv97.node.*;
import cv97.share.*;
import cv97.util.*;

public class ShareNodeRemove extends ShareNode
{
	///////////////////////////////////////////////
	// Constractor
	///////////////////////////////////////////////

	public ShareNodeRemove()
	{
	}

	public ShareNodeRemove(Node node)
	{
		super(node);
	}

	///////////////////////////////////////////////
	// Abstract Methods
	///////////////////////////////////////////////
	
	public boolean writeData(ObjectOutputStream out) throws IOException
	{
		String	nodeName	= getNodeName();

		out.writeObject(nodeName);
		
		return true;
	}

	public boolean readData(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		String 	nodeName	= (String)in.readObject();
		
		setNodeName(nodeName);
		
		return true;
	}

	///////////////////////////////////////////////
	// Update
	///////////////////////////////////////////////
	
	public boolean update(SceneGraph sg)
	{
		if (sg == null)
			return false;

		String	removeNodeName	= getNodeName();
		Node		removeNode		= sg.findNodeByName(removeNodeName);
		
		if (removeNode == null)
			return false;
			
		removeNode.remove(false);
		
		return true;
	}
}
