/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : DirectionalLight.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class DirectionalLightNode extends LightNode {
	
	private String	ambientIntensityFieldName	= "ambientIntensity";
	private String	directionFieldName			= "direction";

	private SFFloat ambientIntensityField;
	private SFVec3f directionField;

	public DirectionalLightNode() {
		setHeaderFlag(false);
		setType(directionalLightTypeName);

		// ambient intensity exposed field
		ambientIntensityField = new SFFloat(0.0f);
		ambientIntensityField.setName(ambientIntensityFieldName);
		addExposedField(ambientIntensityField);

		// direction exposed field
		directionField = new SFVec3f(0.0f, 0.0f, -1.0f);
		directionField.setName(directionFieldName);
		addExposedField(directionField);
	}

	public DirectionalLightNode(DirectionalLightNode node) {
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
	//	Direction
	////////////////////////////////////////////////

	public SFVec3f getDirectionField() {
		if (isInstanceNode() == false)
			return directionField;
		return (SFVec3f)getExposedField(directionFieldName);
	}

	public void setDirection(float value[]) {
		getDirectionField().setValue(value);
	}
	
	public void setDirection(float x, float y, float z) {
		getDirectionField().setValue(x, y, z);
	}

	public void setDirection(String value) {
		getDirectionField().setValue(value);
	}
	
	public void getDirection(float value[]) {
		getDirectionField().getValue(value);
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
		float rot[] = new float[4];

		SFBool bon = getOnField();
		printStream.println(indentString + "\t" + "on " + bon );

		printStream.println(indentString + "\t" + "intensity " + getIntensity() );
		printStream.println(indentString + "\t" + "ambientIntensity " + getAmbientIntensity() );
		getColor(vec);			printStream.println(indentString + "\t" + "color " + vec[X] + " "+ vec[Y] + " " + vec[Z] );
		getDirection(vec);		printStream.println(indentString + "\t" + "direction " + vec[X] + " "+ vec[Y] + " " + vec[Z] );
	}
}
