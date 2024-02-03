/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: Cone.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.util.*;
import cv97.field.*;

public class ConeNode extends GeometryNode {

	private String	bottomRadiusFieldName	= "bottomRadius";
	private String	heightFieldName			= "height";
	private String	topFieldName				= "top";
	private String	sideFieldName				= "side";
	private String	bottomFieldName			= "bottom";

	private SFFloat 	bottomRadiusField;
	private SFFloat 	heightField;
	private SFBool 	sideField;
	private SFBool 	bottomField;
	
	public ConeNode() {

		setHeaderFlag(false);
		setType(coneTypeName);

		// bottomRadius field
		bottomRadiusField = new SFFloat(1.0f);
		addExposedField(bottomRadiusFieldName, bottomRadiusField);

		// height field
		heightField = new SFFloat(2.0f);
		addExposedField(heightFieldName, heightField);

		// side field
		sideField = new SFBool(true);
		addExposedField(sideFieldName, sideField);

		// bottom field
		bottomField = new SFBool(true);
		addExposedField(bottomFieldName, bottomField);
	}

	public ConeNode(ConeNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	bottomRadius
	////////////////////////////////////////////////

	public SFFloat getBottomRadiusField() {
		if (isInstanceNode() == false)
			return bottomRadiusField;
		return (SFFloat)getExposedField(bottomRadiusFieldName);
	}

	public void setBottomRadius(float value) {
		getBottomRadiusField().setValue(value);
	}

	public void setBottomRadius(String value) {
		getBottomRadiusField().setValue(value);
	}
	
	public float getBottomRadius() {
		return getBottomRadiusField().getValue();
	}

	////////////////////////////////////////////////
	//	height
	////////////////////////////////////////////////

	public SFFloat getHeightField() {
		if (isInstanceNode() == false)
			return heightField;
		return (SFFloat)getExposedField(heightFieldName);
	}
	
	public void setHeight(float value) {
		getHeightField().setValue(value);
	}

	public void setHeight(String value) {
		getHeightField().setValue(value);
	}
	
	public float getHeight() {
		return getHeightField().getValue();
	}

	////////////////////////////////////////////////
	//	side
	////////////////////////////////////////////////

	public SFBool getSideField() {
		if (isInstanceNode() == false)
			return sideField;
		return (SFBool)getExposedField(sideFieldName);
	}

	public void setSide(boolean value) {
		getSideField().setValue(value);
	}

	public void setSide(String value) {
		getSideField().setValue(value);
	}
	
	public boolean getSide() {
		return getSideField().getValue();
	}

	////////////////////////////////////////////////
	//	bottom
	////////////////////////////////////////////////

	public SFBool getBottomField() {
		if (isInstanceNode() == false)
			return bottomField;
		return (SFBool)getExposedField(bottomFieldName);
	}

	public void setBottom(boolean value) {
		getBottomField().setValue(value);
	}

	public void setBottom(String value) {
		getBottomField().setValue(value);
	}
	
	public boolean getBottom() {
		return getBottomField().getValue();
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
		calculateBoundingBox();
	}

	public void uninitialize() {
	}

	public void update() {
	}

	////////////////////////////////////////////////
	//	BoundingBox
	////////////////////////////////////////////////
	
	public void calculateBoundingBox() {
		setBoundingBoxCenter(0.0f, 0.0f, 0.0f);
		setBoundingBoxSize(getBottomRadius(), getHeight()/2.0f, getBottomRadius());
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool side = (SFBool)getExposedField(sideFieldName);
		SFBool bottom = (SFBool)getExposedField(bottomFieldName);

		printStream.println(indentString + "\t" + "bottomRadius " + getBottomRadius());
		printStream.println(indentString + "\t" + "height " + getHeight());
		printStream.println(indentString + "\t" + "side " + side);
		printStream.println(indentString + "\t" + "bottom " + bottom);
	}
}
