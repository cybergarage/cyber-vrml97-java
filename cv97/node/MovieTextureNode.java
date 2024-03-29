/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : MovieTexture.java
*
******************************************************************/

package cv97.node;

import java.util.Vector;
import java.lang.String;
import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class MovieTextureNode extends TextureNode {
	
	//// Exposed Field ////////////////
	private String	urlFieldName				= "url";
	private String	loopFieldName				= "loop";
	private String	startTimeFieldName		= "startTime";
	private String	stopTimeFieldName		= "stopTime";
	private String	speedFieldName			= "speedTime";

	private MFString urlField;
	private SFBool loopField;
	private SFTime startTimeField;
	private SFTime stopTimeField;
	private SFFloat speedField;
	private ConstSFBool isActiveField;
	private ConstSFTime durationField;


	public MovieTextureNode() {
		setHeaderFlag(false);
		setType(movieTextureTypeName);

		///////////////////////////
		// Exposed Field 
		///////////////////////////

		// url field
		urlField = new MFString();
		addExposedField(urlFieldName, urlField);

		// loop exposed field
		loopField = new SFBool(false);
		addExposedField(loopFieldName, loopField);

		// startTime exposed field
		startTimeField = new SFTime(0.0f);
		addExposedField(startTimeFieldName, startTimeField);

		// stopTime exposed field
		stopTimeField = new SFTime(0.0f);
		addExposedField(stopTimeFieldName, stopTimeField);

		// speed exposed field
		speedField = new SFFloat(1);
		addExposedField(speedFieldName, speedField);

		///////////////////////////
		// EventOut
		///////////////////////////

		// isActive eventOut field
		isActiveField = new ConstSFBool(false);
		addEventOut(isActiveFieldName, isActiveField);

		// time eventOut field
		durationField = new ConstSFTime(-1.0f);
		addEventOut(durationFieldName, durationField);
	}

	public MovieTextureNode(MovieTextureNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	// URL
	////////////////////////////////////////////////

	public MFString getURLField() {
		if (isInstanceNode() == false)
			return urlField;
		return (MFString)getExposedField(urlFieldName);
	}

	public void addURL(String value) {
		getURLField().addValue(value);
	}
	
	public int getNURLs() {
		return getURLField().getSize();
	}
	
	public void setURL(int index, String value) {
		getURLField().set1Value(index, value);
	}

	public void setURLs(String value) {
		getURLField().setValues(value);
	}

	public void setURLs(String value[]) {
		getURLField().setValues(value);
	}
	
	public String getURL(int index) {
		return getURLField().get1Value(index);
	}
	
	public void removeURL(int index) {
		getURLField().removeValue(index);
	}

	////////////////////////////////////////////////
	//	Loop
	////////////////////////////////////////////////

	public SFBool getLoopField() {
		if (isInstanceNode() == false)
			return loopField;
		return (SFBool)getExposedField(loopFieldName);
	}
	
	public void setLoop(boolean value) {
		getLoopField().setValue(value);
	}

	public void setLoop(String value) {
		getLoopField().setValue(value);
	}
	
	public boolean getLoop() {
		return getLoopField().getValue();
	}
	
	public boolean IsLoop() {
		return getLoop();
	}

	////////////////////////////////////////////////
	//	Speed
	////////////////////////////////////////////////
	
	public SFFloat getSpeedField() {
		if (isInstanceNode() == false)
			return speedField;
		return (SFFloat)getExposedField(speedFieldName);
	}

	public void setSpeed(float value) {
		getSpeedField().setValue(value);
	}

	public void setSpeed(String value) {
		getSpeedField().setValue(value);
	}
	
	public float getSpeed() {
		return getSpeedField().getValue();
	}

	////////////////////////////////////////////////
	//	Start time
	////////////////////////////////////////////////

	public SFTime getStartTimeField() {
		if (isInstanceNode() == false)
			return startTimeField;
		return (SFTime)getExposedField(startTimeFieldName);
	}
	
	public void setStartTime(double value) {
		getStartTimeField().setValue(value);
	}

	public void setStartTime(String value) {
		getStartTimeField().setValue(value);
	}
	
	public double getStartTime() {
		return getStartTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	Stop time
	////////////////////////////////////////////////

	public SFTime getStopTimeField() {
		if (isInstanceNode() == false)
			return stopTimeField;
		return (SFTime)getExposedField(stopTimeFieldName);
	}
	
	public void setStopTime(double value) {
		getStopTimeField().setValue(value);
	}

	public void setStopTime(String value) {
		getStopTimeField().setValue(value);
	}
	
	public double getStopTime() {
		return getStopTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	isActive
	////////////////////////////////////////////////

	public ConstSFBool getIsActiveField() {
		if (isInstanceNode() == false)
			return isActiveField;
		return (ConstSFBool)getEventOut(isActiveFieldName);
	}
	
	public void setIsActive(boolean value) {
		getIsActiveField().setValue(value);
	}

	public void setIsActive(String value) {
		getIsActiveField().setValue(value);
	}
	
	public boolean getIsActive() {
		return getIsActiveField().getValue();
	}
	
	public boolean isActive() {
		return getIsActiveField().getValue();
	}

	////////////////////////////////////////////////
	//	duration_changed
	////////////////////////////////////////////////

	public ConstSFTime getDurationChangedField() {
		if (isInstanceNode() == false)
			return durationField;
		return (ConstSFTime)getEventOut(durationFieldName);
	}
	
	public void setDurationChanged(double value) {
		getDurationChangedField().setValue(value);
	}

	public void setDurationChanged(String value) {
		getDurationChangedField().setValue(value);
	}
	
	public double getDurationChanged() {
		return getDurationChangedField().getValue();
	}

	public ConstSFTime getDurationField() {
		return getDurationChangedField();
	}
	
	public void setDuration(double value) {
		getDurationField().setValue(value);
	}

	public void setDuration(String value) {
		getDurationField().setValue(value);
	}
	
	public double getDuration() {
		return getDurationField().getValue();
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
	//	infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool loop = getLoopField();
		SFBool repeatS = getRepeatSField();
		SFBool repeatT = getRepeatTField();

		printStream.println(indentString + "\t" + "loop " + loop );
		printStream.println(indentString + "\t" + "speed " + getSpeed() );
		printStream.println(indentString + "\t" + "startTime " + getStartTime() );
		printStream.println(indentString + "\t" + "stopTime " + getStopTime() );
		printStream.println(indentString + "\t" + "repeatS " + repeatS );
		printStream.println(indentString + "\t" + "repeatT " + repeatT );

		MFString url = getURLField();
		printStream.println(indentString + "\t" + "url [");
		url.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");
	}
}
