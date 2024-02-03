/******************************************************************
*
*	Simple VRML Applet Viewer for Java3D
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File:	Polygon3D.java
*
******************************************************************/

public class Polygon3D {

	public int npoints;
	public float pos[][];
	public float color[] = new float[3];
	
	public Polygon3D(int nPoints)
	{
		npoints = nPoints;
		pos = new float[nPoints][3];
	}

	////////////////////////////////////////////////
	// Vertex Positon
	////////////////////////////////////////////////
	
	public void set(int n, float val[])
	{
		pos[n][0] = val[0];
		pos[n][1] = val[1];
		pos[n][2] = val[2];
	}

	public void get(int n, float val[])
	{
		val[0] = pos[n][0];
		val[1] = pos[n][1];
		val[2] = pos[n][2];
	}


	////////////////////////////////////////////////
	// Vertex Positon
	////////////////////////////////////////////////
	
	public void setColor(float val[])
	{
		color[0] = val[0];
		color[1] = val[1];
		color[2] = val[2];
	}

	public float []getColor()
	{
		return color;
	}
	
	////////////////////////////////////////////////
	// Middle Positon
	////////////////////////////////////////////////
	
	public void getMidPos(float mid[])
	{
		mid[0] = 0;
		mid[1] = 0;
		mid[2] = 0;
		for (int n=0; n<npoints; n++) {
			mid[0] = pos[n][0];
			mid[1] = pos[n][1];
			mid[2] = pos[n][2];
		}
		mid[0] /= npoints;
		mid[1] /= npoints;
		mid[2] /= npoints;
	}

	////////////////////////////////////////////////
	// Normal
	////////////////////////////////////////////////
	
	public void getNormal(float vec[])
	{
		vec[0] = (pos[1][1] - pos[0][1])*(pos[2][2] - pos[1][2]) - (pos[1][2] - pos[0][2])*(pos[2][1] - pos[1][1]);
		vec[1] = (pos[1][2] - pos[0][2])*(pos[2][0] - pos[1][0]) - (pos[1][0] - pos[0][0])*(pos[2][2] - pos[1][2]);
		vec[2] = (pos[1][0] - pos[0][0])*(pos[2][1] - pos[1][1]) - (pos[1][1] - pos[0][1])*(pos[2][0] - pos[1][0]);
	}

}
