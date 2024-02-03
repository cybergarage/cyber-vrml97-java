/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: LightNode.java
*
******************************************************************/

package cv97.node;

import cv97.*;
import cv97.field.*;

public abstract class LightNode extends Node {

	private String	onFieldString					= "on";
	private String	intensityFieldString		= "intensity";
	private String	colorFieldString				= "color";

	private SFBool 	onField;
	private SFFloat 	intensityField;
	private SFColor 	colorField;

		// color exposed field

	public LightNode() {
		setHeaderFlag(false);

		// on exposed field
		onField = new SFBool(true);
		onField.setName(onFieldString);
		addExposedField(onField);

		// intensity exposed field
		intensityField = new SFFloat(1.0f);
		intensityField.setName(intensityFieldString);
		addExposedField(intensityField);

		// color exposed field
		colorField = new SFColor(1.0f, 1.0f, 1.0f);
		colorField.setName(colorFieldString);
		addExposedField(colorField);
	}

	////////////////////////////////////////////////
	//	On
	////////////////////////////////////////////////

	public SFBool getOnField() {
		if (isInstanceNode() == false)
			return onField;
		return (SFBool)getExposedField(onFieldString);
	}
	
	public void setOn(boolean on) {
		getOnField().setValue(on);
	}

	public void setOn(String on) {
		getOnField().setValue(on);
	}
	
	public boolean getOn() {
		return getOnField().getValue();
	}
	
	public boolean isOn() {
		return getOnField().getValue();
	}
	
	////////////////////////////////////////////////
	//	Intensity
	////////////////////////////////////////////////

	public SFFloat getIntensityField() {
		if (isInstanceNode() == false)
			return intensityField;
		return (SFFloat)getExposedField(intensityFieldString);
	}
	
	public void setIntensity(float value) {
		getIntensityField().setValue(value);
	}

	public void setIntensity(String value) {
		getIntensityField().setValue(value);
	}
	
	public float getIntensity() {
		return getIntensityField().getValue();
	}

	////////////////////////////////////////////////
	//	Color
	////////////////////////////////////////////////

	public SFColor getColorField() {
		if (isInstanceNode() == false)
			return colorField;
		return (SFColor)getExposedField(colorFieldString);
	}

	public void setColor(float value[]) {
		getColorField().setValue(value);
	}
	
	public void setColor(float r, float g, float b) {
		getColorField().setValue(r, g, b);
	}

	public void setColor(String value) {
		getColorField().setValue(value);
	}
	
	public void getColor(float value[]) {
		getColorField().getValue(value);
	}
}