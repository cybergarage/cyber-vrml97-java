/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : PlaneSensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class PlaneSensorNode extends SensorNode {
	
	private String	autoOffsetFieldName		= "autoOffset";
	private String	minPositionFieldName	= "minPosition";
	private String	maxPositionFieldName	= "maxPosition";
	private String	offsetFieldName			= "offset";
	private String	translationEventOutName	= "translation";
	private String	trackPointEventOutName	= "trackPoint";

	private SFBool autoOffsetField;
	private SFVec2f minPositionField;
	private SFVec2f maxPositionField;
	private SFVec3f offsetField;
	private ConstSFVec3f translationField;
	private ConstSFVec3f trackPointField;

	public PlaneSensorNode() {
		setHeaderFlag(false);
		setType(planeSensorTypeName);

		// autoOffset exposed field
		autoOffsetField = new SFBool(true);
		addExposedField(autoOffsetFieldName, autoOffsetField);

		// minPosition exposed field
		minPositionField = new SFVec2f(0.0f, 0.0f);
		addExposedField(minPositionFieldName, minPositionField);

		// maxAngle exposed field
		maxPositionField = new SFVec2f(-1.0f, -1.0f);
		addExposedField(maxPositionFieldName, maxPositionField);

		// offset exposed field
		offsetField = new SFVec3f(0.0f, 0.0f, 0.0f);
		addExposedField(offsetFieldName, offsetField);
	

		// translation eventOut field
		translationField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(translationEventOutName, translationField);

		// trackPoint eventOut field
		trackPointField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(trackPointEventOutName, trackPointField);
	}
	
	public PlaneSensorNode(PlaneSensorNode node) {
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
	//	MinPosition
	////////////////////////////////////////////////

	public SFVec2f getMinPositionField() {
		if (isInstanceNode() == false)
			return minPositionField;
		return (SFVec2f)getExposedField(minPositionFieldName);
	}

	public void setMinPosition(float value[]) {
		getMinPositionField().setValue(value);
	}
	
	public void setMinPosition(float x, float y) {
		getMinPositionField().setValue(x, y);
	}

	public void setMinPositions(String value) {
		getMinPositionField().setValue(value);
	}

	public void getMinPosition(float value[]) {
		getMinPositionField().getValue();
	}

	////////////////////////////////////////////////
	//	MaxPosition
	////////////////////////////////////////////////

	public SFVec2f getMaxPositionField() {
		if (isInstanceNode() == false)
			return maxPositionField;
		return (SFVec2f)getExposedField(maxPositionFieldName);
	}
	
	public void setMaxPosition(float value[]) {
		getMaxPositionField().setValue(value);
	}
	
	public void setMaxPosition(float x, float y) {
		getMaxPositionField().setValue(x, y);
	}

	public void setMaxPosition(String value) {
		getMaxPositionField().setValue(value);
	}
	
	public void getMaxPosition(float value[]) {
		getMaxPositionField().getValue();
	}

	////////////////////////////////////////////////
	//	Offset
	////////////////////////////////////////////////

	public SFVec3f getOffsetField() {
		if (isInstanceNode() == false)
			return offsetField;
		return (SFVec3f)getExposedField(offsetFieldName);
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
	//	Translation
	////////////////////////////////////////////////
	
	public ConstSFVec3f getTranslationChangedField() {
		if (isInstanceNode() == false)
			return translationField;
		return (ConstSFVec3f)getEventOut(translationEventOutName);
	}
	
	public void setTranslationChanged(float value[]) {
		getTranslationChangedField().setValue(value);
	}
	
	public void setTranslationChanged(float x, float y, float z) {
		getTranslationChangedField().setValue(x, y, z);
	}

	public void setTranslationChanged(String value) {
		getTranslationChangedField().setValue(value);
	}
	
	public void getTranslationChanged(float value[]) {
		getTranslationChangedField().getValue(value);
	}

	public ConstSFVec3f getTranslationdField() {
		return getTranslationChangedField();
	}
	
	public void setTranslationd(float value[]) {
		getTranslationdField().setValue(value);
	}
	
	public void setTranslationd(float x, float y, float z) {
		getTranslationdField().setValue(x, y, z);
	}

	public void setTranslationd(String value) {
		getTranslationdField().setValue(value);
	}
	
	public void getTranslationd(float value[]) {
		getTranslationdField().getValue(value);
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

	public ConstSFVec3f getTrackPointdField() {
		return getTrackPointChangedField();
	}
	
	public void setTrackPointd(float value[]) {
		getTrackPointdField().setValue(value);
	}
	
	public void setTrackPointd(float x, float y, float z) {
		getTrackPointdField().setValue(x, y, z);
	}

	public void setTrackPointd(String value) {
		getTrackPointdField().setValue(value);
	}
	
	public void getTrackPointd(float value[]) {
		getTrackPointdField().getValue(value);
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
		SFVec2f maxpos = getMaxPositionField();
		SFVec2f minpos = getMinPositionField();
		SFVec3f offset = getOffsetField();

		printStream.println(indentString + "\t" + "autoOffset " + autoOffset );
		printStream.println(indentString + "\t" + "enabled " + enabled );
		printStream.println(indentString + "\t" + "maxPosition " + maxpos );
		printStream.println(indentString + "\t" + "minPosition " + minpos );
		printStream.println(indentString + "\t" + "offset " + offset );
	}
}
