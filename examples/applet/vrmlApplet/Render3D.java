/******************************************************************
*
*	Simple VRML Applet Viewer for Java3D
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File:	Render3D.java
*
******************************************************************/

public class Render3D
{
	////////////////////////////////////////////////
	// getLambertColor
	////////////////////////////////////////////////

	public static float getLambertIntensity(float v1[], float v2[])
	{
		float intensity = Math3D.dot(v1, v2);
		if (intensity < 0.0f)
			intensity = 0.0f;
		return intensity;
	}
	
	public static void getLambertColor(float color[], float intensity)
	{
		if (intensity < 0.0f)
			intensity = 0.0f;
		if (intensity > 1.0f)
			intensity = 1.0f;
		color[0] *= intensity;		
		color[1] *= intensity;		
		color[2] *= intensity;		
	}
	
}
