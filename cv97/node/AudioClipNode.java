/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : AudioClip.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class AudioClipNode extends Node {
	
	private String	descriptionExposedFieldName		= "description";
	private String	loopExposedFieldName			= "loop";
	private String	startTimeExposedFieldName		= "startTime";
	private String	stopTimeExposedFieldName		= "stopTime";
	private String	pitchExposedFieldName			= "pitch";
	private String	urlExposedFieldName				= "url";
	private String	isActiveEventInName				= "isActive";
	private String	durationEventOutName			= "duration";

	private SFString			descriptionField;
	private SFBool 			loopField;
	private SFTime			startTimeField;
	private SFTime			stopTimeField;
	private SFFloat			pitchField;
	private MFString			urlField;
	private ConstSFBool		isActiveField;
	private ConstSFTime		durationField;

	public AudioClipNode() {
		setHeaderFlag(false);
		setType(audioClipTypeName);

		// description exposed field
		descriptionField = new SFString();
		addExposedField(descriptionExposedFieldName, descriptionField);

		// loop exposed field
		loopField = new SFBool(true);
		addExposedField(loopExposedFieldName, loopField);

		// startTime exposed field
		startTimeField = new SFTime(0.0f);
		addExposedField(startTimeExposedFieldName, startTimeField);

		// stopTime exposed field
		stopTimeField = new SFTime(0.0f);
		addExposedField(stopTimeExposedFieldName, stopTimeField);

		// pitch exposed field
		pitchField = new SFFloat(1.0f);
		addExposedField(pitchExposedFieldName, pitchField);

		// url exposed field
		urlField = new MFString();
		addExposedField(urlExposedFieldName, urlField);

		
		// isActive eventOut field
		isActiveField = new ConstSFBool(false);
		addEventOut(isActiveEventInName, isActiveField);

		// time eventOut field
		durationField = new ConstSFTime(-1.0f);
		addEventOut(durationEventOutName, durationField);
	}

	public AudioClipNode(AudioClipNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	Description
	////////////////////////////////////////////////

	public SFString getDescriptionField() {
		if (isInstanceNode() == false)
			return descriptionField;
		return (SFString)getExposedField(descriptionExposedFieldName);
	}

	public void setDescription(String value) {
		getDescriptionField().setValue(value);
	}

	public String getDescription() {
		return getDescriptionField().getValue();
	}

	////////////////////////////////////////////////
	//	Loop
	////////////////////////////////////////////////

	public SFBool getLoopField() {
		if (isInstanceNode() == false)
			return loopField;
		return (SFBool)getExposedField(loopExposedFieldName);
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
	
	public boolean isLoop() {
		return getLoop();
	}

	////////////////////////////////////////////////
	//	Pitch
	////////////////////////////////////////////////

	public SFFloat getPitchField() {
		if (isInstanceNode() == false)
			return pitchField;
		return (SFFloat)getExposedField(pitchExposedFieldName);
	}
	
	public void setPitch(float value) {
		getPitchField().setValue(value);
	}

	public void setPitch(String value) {
		getPitchField().setValue(value);
	}

	public float getPitch() {
		return getPitchField().getValue();
	}

	////////////////////////////////////////////////
	//	Start time
	////////////////////////////////////////////////

	public SFTime getStartTimeField() {
		if (isInstanceNode() == false)
			return startTimeField;
		return (SFTime)getExposedField(startTimeExposedFieldName);
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
		return (SFTime)getExposedField(stopTimeExposedFieldName);
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
		return (ConstSFBool)getEventOut(isActiveEventInName);
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
		return getIsActive();
	}

	////////////////////////////////////////////////
	//	duration_changed
	////////////////////////////////////////////////
	
	public ConstSFTime getDurationChangedField() {
		if (isInstanceNode() == false)
			return durationField;
		return (ConstSFTime)getEventOut(durationEventOutName);
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
		setDurationChanged(value);
	}

	public void setDuration(String value) {
		setDurationChanged(value);
	}

	public double getDuration() {
		return getDurationChanged();
	}

	////////////////////////////////////////////////
	// URL
	////////////////////////////////////////////////

	public MFString getURLField() {
		if (isInstanceNode() == false)
			return urlField;
		return (MFString)getExposedField(urlExposedFieldName);
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
		SFString description = getDescriptionField();
		printStream.println(indentString + "\t" + "description " + description );

		printStream.println(indentString + "\t" + "pitch " + getPitch() );
		printStream.println(indentString + "\t" + "startTime " + getStartTime() );
		printStream.println(indentString + "\t" + "stopTime " + getStopTime() );

		SFBool loop = getLoopField();
		printStream.println(indentString + "\t" + "loop " + loop);

		MFString url = getURLField();
		printStream.println(indentString + "\t" + "url [");
		url.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");
	}
}
