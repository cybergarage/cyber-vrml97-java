/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : PointLight.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class PointLightNode extends LightNode {

	private String	ambientIntensityFieldName	= "ambientIntensity";
	private String	locationFieldName				= "location";
	private String	radiusFieldName				= "radius";
	private String	attenuationFieldName			= "attenuation";

	private SFFloat ambientIntensityField;
	private SFVec3f locationField;
	private SFFloat radiusField;
	private SFVec3f attenuationField;
	
	public PointLightNode() {
		setHeaderFlag(false);
		setType(pointLightTypeName);

		// ambient intensity exposed field
		ambientIntensityField = new SFFloat(0.0f);
		ambientIntensityField.setName(ambientIntensityFieldName);
		addExposedField(ambientIntensityField);

		// location exposed field
		locationField = new SFVec3f(0.0f, 0.0f, 0.0f);
		locationField.setName(locationFieldName);
		addExposedField(locationField);

		// radius exposed field
		radiusField = new SFFloat(100.0f);
		radiusField.setName(radiusFieldName);
		addExposedField(radiusField);

		// attenuation exposed field
		attenuationField = new SFVec3f(1.0f, 0.0f, 0.0f);
		attenuationField.setName(attenuationFieldName);
		addExposedField(attenuationField);
	}

	public PointLightNode(PointLightNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	AmbientIntensity
	////////////////////////////////////////////////

	public SFFloat getAmbientIntensityField() {
		if (isInstanceNode() == false)
			return ambientIntensityField;
		return (SFFloat)getExposedField(ambientIntensityFieldName);
	}
	
	public void setAmbientIntensity(float value) {
		getAmbientIntensityField().setValue(value);
	}

	public void setAmbientIntensity(String value) {
		getAmbientIntensityField().setValue(value);
	}
	
	public float getAmbientIntensity() {
		return getAmbientIntensityField().getValue();
	}

	////////////////////////////////////////////////
	//	Location
	////////////////////////////////////////////////

	public SFVec3f getLocationField() {
		if (isInstanceNode() == false)
			return locationField;
		return (SFVec3f)getExposedField(locationFieldName);
	}
	
	public void setLocation(float value[]) {
		getLocationField().setValue(value);
	}
	
	public void setLocation(float x, float y, float z) {
		getLocationField().setValue(x, y, z);
	}

	public void setLocation(String value) {
		getLocationField().setValue(value);
	}
	
	public void getLocation(float value[]) {
		getLocationField().getValue(value);
	}

	////////////////////////////////////////////////
	//	Radius
	////////////////////////////////////////////////

	public SFFloat getRadiusField() {
		if (isInstanceNode() == false)
			return radiusField;
		return (SFFloat)getExposedField(radiusFieldName);
	}
	
	public void setRadius(float value) {
		getRadiusField().setValue(value);
	}

	public void setRadius(String value) {
		getRadiusField().setValue(value);
	}
	
	public float getRadius() {
		return getRadiusField().getValue();
	}

	////////////////////////////////////////////////
	//	Attenuation
	////////////////////////////////////////////////

	public SFVec3f getAttenuationField() {
		if (isInstanceNode() == false)
			return attenuationField;
		return (SFVec3f)getExposedField(attenuationFieldName);
	}

	public void setAttenuation(float value[]) {
		getAttenuationField().setValue(value);
	}
	
	public void setAttenuation(float x, float y, float z) {
		getAttenuationField().setValue(x, y, z);
	}

	public void setAttenuation(String value) {
		getAttenuationField().setValue(value);
	}
	
	public void getAttenuation(float value[]) {
		getAttenuationField().getValue(value);
	}

	////////////////////////////////////////////////
	//	Diffuse Color
	////////////////////////////////////////////////

	public void getDiffuseColor(float value[]) {
		getColor(value);
		float	intensity = getIntensity();
		value[0] *= intensity;
		value[1] *= intensity;
		value[2] *= intensity;
	}

	////////////////////////////////////////////////
	//	Ambient Color
	////////////////////////////////////////////////

	public void getAmbientColor(float value[]) {
		getColor(value);
		float	intensity = getIntensity();
		float	ambientIntensity = getAmbientIntensity();
		value[0] *= intensity * ambientIntensity;
		value[1] *= intensity * ambientIntensity;
		value[2] *= intensity * ambientIntensity;
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
	}

	public void uninitialize() {
	}

	public void update() {
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		float vec[] = new float[3];

		SFBool bon = getOnField();
		printStream.println(indentString + "\t" + "on " + bon );

		printStream.println(indentString + "\t" + "intensity " + getIntensity() );
		printStream.println(indentString + "\t" + "ambientIntensity " + getAmbientIntensity() );
		getColor(vec);			printStream.println(indentString + "\t" + "color " + vec[X] + " "+ vec[Y] + " " + vec[Z] );
		getLocation(vec);		printStream.println(indentString + "\t" + "location " + vec[X] + " "+ vec[Y] + " " + vec[Z] );
		printStream.println(indentString + "\t" + "radius " + getRadius() );
		getAttenuation(vec);	printStream.println(indentString + "\t" + "attenuation " + vec[X] + " "+ vec[Y] + " " + vec[Z] );
	}
}
