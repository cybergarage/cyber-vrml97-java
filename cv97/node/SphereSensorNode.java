/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : SphereSensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class SphereSensorNode extends SensorNode {
	
	private String	autoOffsetFieldName		= "autoOffset";
	private String	offsetFieldName			= "offset";
	private String	rotationEventOutName	= "rotation";
	private String	trackPointEventOutName	= "trackPoint";

	private SFBool 				autoOffsetField;
	private SFRotation			offsetField;
	private ConstSFRotation	rotationField;
	private ConstSFVec3f		trackPointField;

	public SphereSensorNode() {
		setHeaderFlag(false);
		setType(sphereSensorTypeName);

		// autoOffset exposed field
		autoOffsetField = new SFBool(true);
		addExposedField(autoOffsetFieldName, autoOffsetField);

		// offset exposed field
		offsetField = new SFRotation(0.0f, 0.0f, 1.0f, 0.0f);
		addExposedField(offsetFieldName, offsetField);
		

		// rotation eventOut field
		rotationField = new ConstSFRotation(0.0f, 0.0f, 1.0f, 0.0f);
		addEventOut(rotationEventOutName, rotationField);

		// trackPoint eventOut field
		trackPointField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(trackPointEventOutName, trackPointField);
	}

	public SphereSensorNode(SphereSensorNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	AutoOffset
	////////////////////////////////////////////////

	public SFBool getAutoOffsetField() {
		if (isInstanceNode() == false)
			return autoOffsetField;
		return (SFBool)getExposedField(autoOffsetFieldName);
	}
	
	public void setAutoOffset(boolean value) {
		getAutoOffsetField().setValue(value);
	}

	public void setAutoOffset(String value) {
		getAutoOffsetField().setValue(value);
	}

	public boolean getAutoOffset() {
		return getAutoOffsetField().getValue();
	}
	
	public boolean isAutoOffset() {
		return getAutoOffset();
	}

	////////////////////////////////////////////////
	//	Offset
	////////////////////////////////////////////////

	public SFRotation getOffsetField() {
		if (isInstanceNode() == false)
			return offsetField;
		return (SFRotation)getExposedField(offsetFieldName);
	}
	
	public void setOffset(float value[]) {
		getOffsetField().setValue(value);
	}

	public void setOffset(String value) {
		getOffsetField().setValue(value);
	}

	public void getOffset(float value[]) {
		getOffsetField().getValue(value);
	}

	////////////////////////////////////////////////
	//	Rotation
	////////////////////////////////////////////////

	public ConstSFRotation getRotationChangedField() {
		if (isInstanceNode() == false)
			return rotationField;
		return (ConstSFRotation)getEventOut(rotationEventOutName);
	}
	
	public void setRotationChanged(float value[]) {
		getRotationChangedField().setValue(value);
	}
	
	public void setRotationChanged(float x, float y, float z, float rot) {
		getRotationChangedField().setValue(x, y, z, rot);
	}

	public void setRotationChanged(String value) {
		getRotationChangedField().setValue(value);
	}
	
	public void getRotationChanged(float value[]) {
		getRotationChangedField().getValue(value);
	}

	public ConstSFRotation getRotationField() {
		return getRotationChangedField();
	}

	public void setRotation(float value[]) {
		setRotationChanged(value);
	}
	
	public void setRotation(float x, float y, float z, float rot) {
		setRotationChanged(x, y, z, rot);
	}

	public void setRotation(String value) {
		setRotationChanged(value);
	}
	
	public void getRotation(float value[]) {
		getRotationChanged(value);
	}

	////////////////////////////////////////////////
	//	TrackPoint
	////////////////////////////////////////////////

	public ConstSFVec3f getTrackPointChangedField() {
		if (isInstanceNode() == false)
			return trackPointField;
		return (ConstSFVec3f)getEventOut(trackPointEventOutName);
	}
	
	public void setTrackPointChanged(float value[]) {
		getTrackPointChangedField().setValue(value);
	}
	
	public void setTrackPointChanged(float x, float y, float z) {
		getTrackPointChangedField().setValue(x, y, z);
	}

	public void setTrackPointChanged(String value) {
		getTrackPointChangedField().setValue(value);
	}
	
	public void getTrackPointChanged(float value[]) {
		getTrackPointChangedField().getValue(value);
	}

	public ConstSFVec3f getTrackPointField() {
		return getTrackPointChangedField();
	}

	public void setTrackPoint(float value[]) {
		setTrackPointChanged(value);
	}
	
	public void setTrackPoint(float x, float y, float z) {
		setTrackPointChanged(x, y, z);
	}

	public void setTrackPoint(String value) {
		setTrackPointChanged(value);
	}
	
	public void getTrackPoint(float value[]) {
		getTrackPointChanged(value);
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
		setIsActive(false);
	}

	public void uninitialize() {
	}

	public void update() {
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool autoOffset = getAutoOffsetField();
		SFBool enabled = getEnabledField();
		SFRotation offset = getOffsetField();

		printStream.println(indentString + "\t" + "autoOffset " + autoOffset );
		printStream.println(indentString + "\t" + "enabled " + enabled );
		printStream.println(indentString + "\t" + "offset " + offset );
	}
}
