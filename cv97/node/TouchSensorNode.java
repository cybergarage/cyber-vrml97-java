/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : TouchSensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class TouchSensorNode extends SensorNode {
	
	private String	hitNormalEventOutName	= "hitNormal";
	private String	hitPointEventOutName		= "hitPoint";
	private String	hitTexCoordEventOutName	= "hitTexCoord";
	private String	isOverEventOutName		= "isOver";
	private String	touchTimeEventOutName	= "touchTime";

	private ConstSFVec3f hitNormalField;
	private ConstSFVec2f hitTexCoordField;
	private ConstSFVec3f hitPointField;
	private ConstSFBool isOverField;
	private ConstSFTime touchTimeField;

	public TouchSensorNode() {
		setHeaderFlag(false);
		setType(touchSensorTypeName);

		// hitNormal eventOut field
		hitNormalField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(hitNormalEventOutName, hitNormalField);

		// hitTexCoord eventOut field
		hitTexCoordField = new ConstSFVec2f(0.0f, 0.0f);
		addEventOut(hitTexCoordEventOutName, hitTexCoordField);

		// hitPoint eventOut field
		hitPointField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(hitPointEventOutName, hitPointField);

		// isOver eventOut field
		isOverField = new ConstSFBool(false);
		addEventOut(isOverEventOutName, isOverField);

		// touchTime eventOut field
		touchTimeField = new ConstSFTime(0.0f);
		addEventOut(touchTimeEventOutName, touchTimeField);
	}

	public TouchSensorNode(TouchSensorNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	isOver
	////////////////////////////////////////////////

	public ConstSFBool getIsOverField() {
		if (isInstanceNode() == false)
			return isOverField;
		return (ConstSFBool)getEventOut(isOverEventOutName);
	}

	public void setIsOver(String value) {
		getIsOverField().setValue(value);
	}
	
	public boolean getIsOver() {
		return getIsOverField().getValue();
	}
	
	public boolean isOver() {
		return getIsOver();
	}

	////////////////////////////////////////////////
	//	hitNormal
	////////////////////////////////////////////////

	public ConstSFVec3f getHitNormalChangedField() {
		if (isInstanceNode() == false)
			return hitNormalField;
		return (ConstSFVec3f)getEventOut(hitNormalEventOutName);
	}
	
	public void setHitNormalChanged(float value[]) {
		getHitNormalChangedField().setValue(value);
	}
	
	public void setHitNormalChanged(float x, float y, float z) {
		getHitNormalChangedField().setValue(x, y, z);
	}

	public void setHitNormalChanged(String value) {
		getHitNormalChangedField().setValue(value);
	}
	
	public void getHitNormalChanged(float value[]) {
		getHitNormalChangedField().getValue(value);
	}

	public void setHitNormal(float value[]) {
		setHitNormalChanged(value);
	}

	public ConstSFVec3f getHitNormalField() {
		return getHitNormalChangedField();
	}
	
	public void setHitNormal(float x, float y, float z) {
		setHitNormalChanged(x, y, z);
	}

	public void setHitNormal(String value) {
		setHitNormalChanged(value);
	}
	
	public void getHitNormal(float value[]) {
		getHitNormalChanged(value);
	}

	////////////////////////////////////////////////
	//	hitPoint
	////////////////////////////////////////////////

	public ConstSFVec3f getHitPointChangedField() {
		if (isInstanceNode() == false)
			return hitPointField;
		return (ConstSFVec3f)getEventOut(hitPointEventOutName);
	}
	
	public void setHitPointChanged(float value[]) {
		getHitPointChangedField().setValue(value);
	}
	
	public void setHitPointChanged(float x, float y, float z) {
		getHitPointChangedField().setValue(x, y, z);
	}

	public void setHitPointChanged(String value) {
		getHitPointChangedField().setValue(value);
	}
	
	public void getHitPointChanged(float value[]) {
		getHitPointChangedField().getValue(value);
	}

	public ConstSFVec3f getHitPointField() {
		return getHitPointChangedField();
	}

	public void setHitPoint(float value[]) {
		setHitPointChanged(value);
	}
	
	public void setHitPoint(float x, float y, float z) {
		setHitPointChanged(x, y, z);
	}

	public void setHitPoint(String value) {
		setHitPointChanged(value);
	}
	
	public void getHitPoint(float value[]) {
		getHitPointChanged(value);
	}

	////////////////////////////////////////////////
	//	hitTexCoord
	////////////////////////////////////////////////

	public ConstSFVec2f getHitTexCoordField() {
		if (isInstanceNode() == false)
			return hitTexCoordField;
		return (ConstSFVec2f)getEventOut(hitTexCoordEventOutName);
	}
	
	public void setHitTexCoord(float value[]) {
		getHitTexCoordField().setValue(value);
	}
	
	public void setHitTexCoord(float x, float y) {
		getHitTexCoordField().setValue(x, y);
	}

	public void setHitTexCoord(String value) {
		getHitTexCoordField().setValue(value);
	}
	
	public void getHitTexCoord(float value[]) {
		getHitTexCoordField().getValue(value);
	}

	////////////////////////////////////////////////
	//	touchTime
	////////////////////////////////////////////////

	public ConstSFTime getTouchTimeField() {
		if (isInstanceNode() == false)
			return touchTimeField;
		return (ConstSFTime)getEventOut(touchTimeEventOutName);
	}
	
	public void setTouchTime(double value) {
		getTouchTimeField().setValue(value);
	}

	public void setTouchTime(String value) {
		getTouchTimeField().setValue(value);
	}
	
	public double getTouchTime() {
		return getTouchTimeField().getValue();
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
		SFBool enabled = getEnabledField();
		printStream.println(indentString + "\t" + "enabled " + enabled );
	}
}
