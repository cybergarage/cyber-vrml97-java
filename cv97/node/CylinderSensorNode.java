/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : CylinderSensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class CylinderSensorNode extends SensorNode {
	
	private String	autoOffsetFieldName		= "autoOffset";
	private String	diskAngleFieldName		= "diskAngle";
	private String	minAngleFieldName		= "minAngle";
	private String	maxAngleFieldName		= "maxAngle";
	private String	offsetFieldName			= "offset";
	private String	rotationEventOutName	= "rotation";
	private String	trackPointEventOutName	= "trackPoint";

	private SFBool autoOffsetField;
	private SFFloat diskAngleField;
	private SFFloat minAngleField;
	private SFFloat maxAngleField;
	private SFFloat offsetField;
	
	private ConstSFRotation rotationField;
	private ConstSFVec3f trackPointField;

	public CylinderSensorNode() {
		setHeaderFlag(false);
		setType(cylinderSensorTypeName);

		// autoOffset exposed field
		autoOffsetField = new SFBool(true);
		addExposedField(autoOffsetFieldName, autoOffsetField);

		// diskAngle exposed field
		diskAngleField = new SFFloat(0.262f);
		addExposedField(diskAngleFieldName, diskAngleField);

		// minAngle exposed field
		minAngleField = new SFFloat(0.0f);
		addExposedField(minAngleFieldName, minAngleField);

		// maxAngle exposed field
		maxAngleField = new SFFloat(-1.0f);
		addExposedField(maxAngleFieldName, maxAngleField);

		// offset exposed field
		offsetField = new SFFloat(0.0f);
		addExposedField(offsetFieldName, offsetField);


		// rotation eventOut field
		rotationField = new ConstSFRotation(0.0f, 0.0f, 1.0f, 0.0f);
		addEventOut(rotationEventOutName, rotationField);

		// trackPoint eventOut field
		trackPointField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(trackPointEventOutName, trackPointField);
	}

	public CylinderSensorNode(CylinderSensorNode node) {
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
	//	DiskAngle
	////////////////////////////////////////////////

	public SFFloat getDiskAngleField() {
		if (isInstanceNode() == false)
			return diskAngleField;
		return (SFFloat)getExposedField(diskAngleFieldName);
	}

	public void setDiskAngle(float value) {
		getDiskAngleField().setValue(value);
	}

	public void setDiskAngle(String value) {
		getDiskAngleField().setValue(value);
	}
	
	public float getDiskAngle() {
		return getDiskAngleField().getValue();
	}

	////////////////////////////////////////////////
	//	MinAngle
	////////////////////////////////////////////////

	public SFFloat getMinAngleField() {
		if (isInstanceNode() == false)
			return minAngleField;
		return (SFFloat)getExposedField(minAngleFieldName);
	}
	
	public void setMinAngle(float value) {
		getMinAngleField().setValue(value);
	}

	public void setMinAngle(String value) {
		getMinAngleField().setValue(value);
	}
	
	public float getMinAngle() {
		return getMinAngleField().getValue();
	}

	////////////////////////////////////////////////
	//	MaxAngle
	////////////////////////////////////////////////

	public SFFloat getMaxAngleField() {
		if (isInstanceNode() == false)
			return maxAngleField;
		return (SFFloat)getExposedField(maxAngleFieldName);
	}
	
	public void setMaxAngle(float value) {
		getMaxAngleField().setValue(value);
	}

	public void setMaxAngle(String value) {
		getMaxAngleField().setValue(value);
	}
	
	public float getMaxAngle() {
		return getMaxAngleField().getValue();
	}

	////////////////////////////////////////////////
	//	Offset
	////////////////////////////////////////////////

	public SFFloat getOffsetField() {
		if (isInstanceNode() == false)
			return offsetField;
		return (SFFloat)getExposedField(offsetFieldName);
	}
	
	public void setOffset(float value) {
		getOffsetField().setValue(value);
	}

	public void setOffset(String value) {
		getOffsetField().setValue(value);
	}
	
	public float getOffset() {
		return getOffsetField().getValue();
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
		getRotationField().setValue(value);
	}
	
	public void setRotation(float x, float y, float z, float rot) {
		getRotationField().setValue(x, y, z, rot);
	}

	public void setRotation(String value) {
		getRotationField().setValue(value);
	}
	
	public void getRotation(float value[]) {
		getRotationField().getValue(value);
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
		getTrackPointField().setValue(value);
	}
	
	public void setTrackPoint(float x, float y, float z) {
		getTrackPointField().setValue(x, y, z);
	}

	public void setTrackPoint(String value) {
		getTrackPointField().setValue(value);
	}
	
	public void getTrackPoint(float value[]) {
		getTrackPointField().getValue(value);
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

		printStream.println(indentString + "\t" + "autoOffset " + autoOffset );
		printStream.println(indentString + "\t" + "diskAngle " + getDiskAngle() );
		printStream.println(indentString + "\t" + "enabled " + enabled );
		printStream.println(indentString + "\t" + "maxAngle " + getMaxAngle() );
		printStream.println(indentString + "\t" + "minAngle " + getMinAngle() );
		printStream.println(indentString + "\t" + "offset " + getOffset() );
	}
}
