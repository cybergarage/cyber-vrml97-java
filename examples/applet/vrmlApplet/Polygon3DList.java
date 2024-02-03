/******************************************************************
*
*	Simple VRML Applet Viewer for Java3D
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File:	Polygon3DList.java
*
******************************************************************/

import java.util.*;

public class Polygon3DList extends Vector {

	public int npoints;
	public float pos[][];

	public Polygon3DList()
	{
	}

	public Polygon3D getPolygon(int n)
	{
		return (Polygon3D)super.get(n);
	}
}
