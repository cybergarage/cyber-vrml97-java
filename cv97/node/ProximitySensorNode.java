/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ProximitySensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;

import cv97.*;
import cv97.field.*;
import cv97.util.Debug;

public class ProximitySensorNode extends SensorNode {
	
	private String	centerFieldName		= "center";
	private String	sizeFieldName			= "size";

	private String	positionEventOutName	= "position";
	private String	orientationEventOutName	= "orientation";
	private String	enterTimeEventOutName	= "enterTime";
	private String	exitTimeEventOutName	= "exitTime";

	private SFVec3f centerField;
	private SFVec3f sizeField;
	private ConstSFVec3f positionField;
	private ConstSFRotation orientationField;
	private ConstSFTime enterTimeField;
	private ConstSFTime exitTimeField;

	public ProximitySensorNode() {
		setHeaderFlag(false);
		setType(proximitySensorTypeName);
		setRunnable(true);

		// center exposed field
		centerField = new SFVec3f(0.0f, 0.0f, 0.0f);
		addExposedField(centerFieldName, centerField);

		// size exposed field
		sizeField = new SFVec3f(0.0f, 0.0f, 0.0f);
		addExposedField(sizeFieldName, sizeField);

		
		// position eventOut field
		positionField = new ConstSFVec3f(0.0f, 0.0f, 0.0f);
		addEventOut(positionEventOutName, positionField);

		// orientation eventOut field
		orientationField = new ConstSFRotation(0.0f, 0.0f, 1.0f, 0.0f);
		addEventOut(orientationEventOutName, orientationField);

		// enterTime eventOut field
		enterTimeField = new ConstSFTime(0.0f);
		addEventOut(enterTimeEventOutName, enterTimeField);

		// exitTime eventOut field
		exitTimeField = new ConstSFTime(0.0f);
		addEventOut(exitTimeEventOutName, exitTimeField);
	}

	public ProximitySensorNode(ProximitySensorNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	Center
	////////////////////////////////////////////////

	public SFVec3f getCenterField() {
		if (isInstanceNode() == false)
			return centerField;
		return (SFVec3f)getExposedField(centerFieldName);
	}
	
	public void setCenter(float value[]) {
		getCenterField().setValue(value);
	}
	
	public void setCenter(float x, float y, float z) {
		getCenterField().setValue(x, y, z);
	}

	public void setCenter(String value) {
		getCenterField().setValue(value);
	}
	
	public void getCenter(float value[]) {
		getCenterField().getValue();
	}

	////////////////////////////////////////////////
	//	Size
	////////////////////////////////////////////////

	public SFVec3f getSizeField() {
		if (isInstanceNode() == false)
			return sizeField;
		return (SFVec3f)getExposedField(sizeFieldName);
	}
	
	public void setSize(float value[]) {
		getSizeField().setValue(value);
	}
	
	public void setSize(float x, float y, float z) {
		getSizeField().setValue(x, y, z);
	}

	public void setSize(String value) {
		getSizeField().setValue(value);
	}
	
	public void getSize(float value[]) {
		getSizeField().getValue();
	}

	////////////////////////////////////////////////
	//	Position
	////////////////////////////////////////////////
	
	public ConstSFVec3f getPositionChangedField() {
		if (isInstanceNode() == false)
			return positionField;
		return (ConstSFVec3f)getEventOut(positionEventOutName);
	}
	
	public void setPositionChanged(float value[]) {
		getPositionChangedField().setValue(value);
	}
	
	public void setPositionChanged(float x, float y, float z) {
		getPositionChangedField().setValue(x, y, z);
	}

	public void setPositionChanged(String value) {
		getPositionChangedField().setValue(value);
	}
	
	public void getPositionChanged(float value[]) {
		getPositionChangedField().getValue(value);
	}

	public ConstSFVec3f getPositionField() {
		return getPositionChangedField();
	}
	
	public void setPosition(float value[]) {
		setPositionChanged(value);
	}
	
	public void setPosition(float x, float y, float z) {
		setPositionChanged(x, y, z);
	}

	public void setPosition(String value) {
		setPositionChanged(value);
	}
	
	public void getPosition(float value[]) {
		getPositionChanged(value);
	}

	////////////////////////////////////////////////
	//	Orientation
	////////////////////////////////////////////////

	public ConstSFRotation getOrientationChangedField() {
		if (isInstanceNode() == false)
			return orientationField;
		return (ConstSFRotation)getEventOut(orientationEventOutName);
	}
	
	public void setOrientationChanged(float value[]) {
		getOrientationChangedField().setValue(value);
	}
	
	public void setOrientationChanged(float x, float y, float z, float rot) {
		getOrientationChangedField().setValue(x, y, z, rot);
	}

	public void setOrientationChanged(String value) {
		getOrientationChangedField().setValue(value);
	}
	
	public void getOrientationChanged(float value[]) {
		ConstSFRotation orientation = (ConstSFRotation)getEventOut(orientationEventOutName);
		orientation.getValue(value);
	}

	public ConstSFRotation getOrientationField() {
		return getOrientationChangedField();
	}

	public void setOrientation(float value[]) {
		setOrientationChanged(value);
	}
	
	public void setOrientation(float x, float y, float z, float rot) {
		setOrientationChanged(x, y, z, rot);
	}

	public void setOrientation(String value) {
		setOrientationChanged(value);
	}
	
	public void getOrientation(float value[]) {
		getOrientationChanged(value);
	}

	////////////////////////////////////////////////
	//	EnterTime
	////////////////////////////////////////////////

	public ConstSFTime getEnterTimeField() {
		if (isInstanceNode() == false)
			return enterTimeField;
		return (ConstSFTime)getEventOut(enterTimeEventOutName);
	}

	public void setEnterTime(double value) {
		getEnterTimeField().setValue(value);
	}

	public void setEnterTime(String value) {
		getEnterTimeField().setValue(value);
	}
	
	public double getEnterTime() {
		return getEnterTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	ExitTime
	////////////////////////////////////////////////

	public ConstSFTime getExitTimeField() {
		if (isInstanceNode() == false)
			return exitTimeField;
		return (ConstSFTime)getEventOut(exitTimeEventOutName);
	}
	
	public void setExitTime(double value) {
		getExitTimeField().setValue(value);
	}

	public void setExitTime(String value) {
		getExitTimeField().setValue(value);
	}
	
	public double getExitTime() {
		return getExitTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	 inRegion
	////////////////////////////////////////////////
	
	private boolean mInRegion = false;
	
	public void setInRegion(boolean value) {
		mInRegion = value;
	}

	public boolean inRegion() {
		return mInRegion;
	} 

	public boolean isRegion(float vpos[], float center[], float size[]) {
		for (int n=0; n<3; n++) {
			if (vpos[n] < center[n] - size[n]/2.0f)
				return false;
			if (center[n] + size[n]/2.0f < vpos[n])
				return false;
		}
		return true;
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
		setInRegion(false);
		setRunnableIntervalTime(250);
	}


	public void uninitialize() {
	}

	public double getCurrentSystemTime() {
		Date	date = new Date();
		return (double)date.getTime() / 1000.0;
	}

	private float vpos[]	= new float[3];
	private float center[]	= new float[3];
	private float size[]	= new float[3];
		
	public void update() {
		
		if (isEnabled() == false)
			return;

		SceneGraph sg = getSceneGraph();
		if (sg == null)
			return;

		ViewpointNode view = sg.getViewpointNode();
		if (view == null)
			view = sg.getDefaultViewpointNode();

		view.getPosition(vpos);
		
		getCenter(center);
		getSize(size);

		if (inRegion() == false) {
			if (isRegion(vpos, center, size) == true) {
				setInRegion(true);
				double time = getCurrentSystemTime();
				setEnterTime(time);
				sendEvent(getEventOut(enterTimeEventOutName));
				setIsActive(true);
				sendEvent(getEventOut(isActiveFieldName));
			}
		}
		else {
			if (isRegion(vpos, center, size) == false) {
				setInRegion(false);
				double time = getCurrentSystemTime();
				setExitTime(time);
				sendEvent(getEventOut(exitTimeEventOutName));
				setIsActive(false);
				sendEvent(getEventOut(isActiveFieldName));
			}
		}
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool enabled = getEnabledField();
		SFVec3f center = getCenterField();
		SFVec3f size = getSizeField();

		printStream.println(indentString + "\t" + "enabled " + enabled );
		printStream.println(indentString + "\t" + "center " + center );
		printStream.println(indentString + "\t" + "size " + size );
	}
}
