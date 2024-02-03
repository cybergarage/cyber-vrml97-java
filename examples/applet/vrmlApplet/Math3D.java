/******************************************************************
*
*	Simple VRML Applet Viewer for Java3D
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File:	Math3D.java
*
******************************************************************/

public class Math3D 
{

	////////////////////////////////////////////////
	// norm
	////////////////////////////////////////////////
	
	public static void norm(float vec[])
	{
		float mag = (float)Math.sqrt(vec[0]*vec[0] + vec[1]*vec[1] + vec[2]*vec[2]);
		if (mag != 0.0f) {
			vec[0] /= mag;	
			vec[1] /= mag;
			vec[2] /= mag;
		}
		else {
			vec[0] = 0.0f;
			vec[1] = 0.0f;
			vec[2] = 1.0f;
		}
	}
	

	////////////////////////////////////////////////
	// dot
	////////////////////////////////////////////////
	
	public static float dot(float v1[], float v2[])
	{
		Math3D.norm(v1);
		Math3D.norm(v2);
		return (v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2]);
	}

	////////////////////////////////////////////////
	// dir
	////////////////////////////////////////////////
	
	public static void dir(float v1[], float v2[], float out[])
	{
		out[0] = v2[0] - v1[0];
		out[1] = v2[1] - v1[1];
		out[2] = v2[2] - v1[2];
		Math3D.norm(out);
	}
}
