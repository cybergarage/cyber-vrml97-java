/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: GeometryNode.java
*
******************************************************************/

package cv97.node;

import cv97.*;
import cv97.field.*;

public abstract class GeometryNode extends Node {

	private String	bboxCenterPrivateFieldName				= "bboxCenter";
	private String	bboxSizePrivateFieldName				= "bboxSize";
	private String	displayListNumberPrivateFieldString	= "displayListNumber";

	private SFVec3f bboxCenterField;
	private SFVec3f bboxSizeField;
	private SFInt32 dispListField;

	public GeometryNode() {
		setHeaderFlag(false);

		// bboxCenter field
		bboxCenterField = new SFVec3f(0.0f, 0.0f, 0.0f);
		bboxCenterField.setName(bboxCenterPrivateFieldName);
		addPrivateField(bboxCenterField);

		// bboxSize field
		bboxSizeField = new SFVec3f(-1.0f, -1.0f, -1.0f);
		bboxSizeField.setName(bboxSizePrivateFieldName);
		addPrivateField(bboxSizeField);

		setBoundingBoxCenter(0.0f, 0.0f, 0.0f);
		setBoundingBoxSize(-1.0f, -1.0f, -1.0f);

		// display list field
		dispListField = new SFInt32(0);
		dispListField.setName(displayListNumberPrivateFieldString);
		addPrivateField(dispListField);

		setDisplayListNumber(0);
	}

	////////////////////////////////////////////////
	//	BoundingBoxSize
	////////////////////////////////////////////////

	public SFVec3f getBoundingBoxSizeField() {
		if (isInstanceNode() == false)
			return bboxSizeField;
		return (SFVec3f)getPrivateField(bboxSizePrivateFieldName);
	}
	
	public void setBoundingBoxSize(float value[]) {
		getBoundingBoxSizeField().setValue(value);
	}
	
	public void setBoundingBoxSize(float x, float y, float z) {
		getBoundingBoxSizeField().setValue(x, y, z);
	}

	public void setBoundingBoxSize(String value) {
		getBoundingBoxSizeField().setValue(value);
	}
	
	public void getBoundingBoxSize(float value[]) {
		getBoundingBoxSizeField().getValue(value);
	}
	
	public float[] getBoundingBoxSize() {
		float size[] = new float[3];
		getBoundingBoxSize(size);
		return size;
	}
	
	////////////////////////////////////////////////
	//	BoundingBoxCenter
	////////////////////////////////////////////////

	public SFVec3f getBoundingBoxCenterField() {
		if (isInstanceNode() == false)
			return bboxCenterField;
		return (SFVec3f)getPrivateField(bboxCenterPrivateFieldName);
	}

	public void setBoundingBoxCenter(float value[]) {
		getBoundingBoxCenterField().setValue(value);
	}
	
	public void setBoundingBoxCenter(float x, float y, float z) {
		getBoundingBoxCenterField().setValue(x, y, z);
	}

	public void setBoundingBoxCenter(String value) {
		getBoundingBoxCenterField().setValue(value);
	}
	
	public void getBoundingBoxCenter(float value[]) {
		getBoundingBoxCenterField().getValue(value);
	}

	public float[] getBoundingBoxCenter() {
		float center[] = new float[3];
		getBoundingBoxCenter(center);
		return center;
	}

	////////////////////////////////////////////////
	//	DisplayListNumber
	////////////////////////////////////////////////

	public SFInt32 getDisplayListField() {
		if (isInstanceNode() == false)
			return dispListField;
		return (SFInt32)getPrivateField(displayListNumberPrivateFieldString);
	}

	public void setDisplayListNumber(int n) {
		getDisplayListField().setValue((int)n);
	}

	public int getDisplayListNumber() {
		return getDisplayListField().getValue();
	} 

	////////////////////////////////////////////////
	//	Abstract method
	////////////////////////////////////////////////
	
	abstract public void calculateBoundingBox();
}

