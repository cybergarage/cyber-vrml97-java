/******************************************************************
*
*	CyberVRML97 for Java3D
*
*	Copyright (C) Satoshi Konno 1997-2000 
*Å@
*	File:	ShareNode.java
*
******************************************************************/

package cv97.share.object;

import java.io.*;

import cv97.*;
import cv97.node.*;
import cv97.share.*;
import cv97.util.*;

public abstract class ShareNode extends ShareObject
{
	private transient Node 		mNode;
	private transient String	mNodeName;
	private transient String	mParentNodeName;
	private transient boolean	mIsParentNodeRootNode;
		
	///////////////////////////////////////////////
	// Constractor
	///////////////////////////////////////////////

	public ShareNode()
	{
		setNode(null);
		setParentNodeName(null);
		setParentNodeRootNodeFlag(false);
	}
	
	public ShareNode(Node node)
	{
		this();
		setNode(node);
	}

	///////////////////////////////////////////////
	// Node
	///////////////////////////////////////////////

	public void setNode(Node node)
	{
		mNode = node;
		if (node != null) {
			// Node Name
			String nodeName = node.getName();
			setNodeName(nodeName);
			// Parent Node Name
			Node parentNode = node.getParentNode();
			if (parentNode != null) {
				if (parentNode.isRootNode() == true)
					setParentNodeRootNodeFlag(true);
				String parentNodeName = parentNode.getName();
				setParentNodeName(parentNodeName);
			}			
		}
	}
	
	public Node getNode()
	{
		return mNode;
	}

	///////////////////////////////////////////////
	// NodeName
	///////////////////////////////////////////////

	public void setNodeName(String name)
	{
		mNodeName = name;
	}
	
	public String getNodeName()
	{
		if (mNodeName == null)
			return "";
		return mNodeName;
	}

	///////////////////////////////////////////////
	// ParentNodeName
	///////////////////////////////////////////////

	public void setParentNodeName(String name)
	{
		mParentNodeName = name;
	}
	
	public String getParentNodeName()
	{
		if (mParentNodeName == null)
			return "";
		return mParentNodeName;
	}

	///////////////////////////////////////////////
	// IsParentNodeRootNode
	///////////////////////////////////////////////

	public void setParentNodeRootNodeFlag(boolean flag)
	{
		mIsParentNodeRootNode = flag;
	}
	
	public boolean isParentNodeRootNode()
	{
		return mIsParentNodeRootNode;
	}
}
