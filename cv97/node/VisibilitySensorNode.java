/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : VisibilitySensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class VisibilitySensorNode extends SensorNode {
	
	private String	centerFieldName			= "center";
	private String	sizeFieldName			= "size";

	private String	enterTimeEventOutName	= "enterTime";
	private String	exitTimeEventOutName	= "exitTime";

	private SFVec3f 		centerField;
	private SFVec3f 		sizeField;
	private ConstSFTime	enterTimeField;
	private ConstSFTime	exitTimeField;

	public VisibilitySensorNode() {
		setHeaderFlag(false);
		setType(visibilitySensorTypeName);

		// center exposed field
		centerField = new SFVec3f(0.0f, 0.0f, 0.0f);
		addExposedField(centerFieldName, centerField);

		// size exposed field
		sizeField = new SFVec3f(0.0f, 0.0f, 0.0f);
		addExposedField(sizeFieldName, sizeField);

		
		// enterTime eventOut field
		enterTimeField = new ConstSFTime(0.0f);
		addEventOut(enterTimeEventOutName, enterTimeField);

		// exitTime eventOut field
		exitTimeField = new ConstSFTime(0.0f);
		addEventOut(exitTimeEventOutName, exitTimeField);
	}

	public VisibilitySensorNode(VisibilitySensorNode node) {
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
		SFVec3f center = getCenterField();
		SFVec3f size = getSizeField();

		printStream.println(indentString + "\t" + "enabled " + enabled );
		printStream.println(indentString + "\t" + "center " + center );
		printStream.println(indentString + "\t" + "size " + size );
	}
}
