/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : TimeSensor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;
import cv97.util.Debug;

public class TimeSensorNode extends SensorNode {
	
	private String	loopFieldName				= "loop";
	private String	cybleIntervalFieldName	= "cycleInterval";
	private String	startTimeFieldName		= "startTime";
	private String	stopTimeFieldName			= "stopTime";
	private String	cycleTimeFieldName		= "cycleTime";
	private String	timeFieldName				= "time";

	private SFBool 			loopField;
	private SFTime 			cybleIntervalField;
	private SFTime 			startTimeField;
	private SFTime 			stopTimeField;
	private ConstSFTime 	cycleTimeField;
	private ConstSFTime 	timeField;
	private ConstSFFloat 	fractionField;

	public TimeSensorNode() {
		setHeaderFlag(false);
		setType(timeSensorTypeName);
		//setRunnable(true);

		// loop exposed field
		loopField = new SFBool(true);
		addExposedField(loopFieldName, loopField);

		// cybleInterval exposed field
		cybleIntervalField = new SFTime(1.0);
		addExposedField(cybleIntervalFieldName, cybleIntervalField);

		// startTime exposed field
		startTimeField = new SFTime(0.0f);
		addExposedField(startTimeFieldName, startTimeField);

		// stopTime exposed field
		stopTimeField = new SFTime(0.0f);
		addExposedField(stopTimeFieldName, stopTimeField);

	
		// cycleTime eventOut field
		cycleTimeField = new ConstSFTime(-1.0f);
		addEventOut(cycleTimeFieldName, cycleTimeField);

		// time eventOut field
		timeField = new ConstSFTime(-1.0f);
		addEventOut(timeFieldName, timeField);

		// fraction_changed eventOut field
		fractionField = new ConstSFFloat(0.0f);
		addEventOut(fractionFieldName, fractionField);
	}

	public TimeSensorNode(TimeSensorNode node) {
		this();
		setFieldValues(node);
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
	
	public boolean isLoop() {
		return getLoop();
	}
	
	////////////////////////////////////////////////
	//	Cyble Interval
	////////////////////////////////////////////////

	public SFTime getCycleIntervalField() {
		if (isInstanceNode() == false)
			return cybleIntervalField;
		return (SFTime)getExposedField(cybleIntervalFieldName);
	}
	
	public void setCycleInterval(double value) {
		getCycleIntervalField().setValue(value);
	}

	public void setCycleInterval(String value) {
		getCycleIntervalField().setValue(value);
	}
	
	public double getCycleInterval() {
		return getCycleIntervalField().getValue();
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
	//	fraction_changed
	////////////////////////////////////////////////

	public ConstSFFloat getFractionChangedField() {
		if (isInstanceNode() == false)
			return fractionField;
		return (ConstSFFloat)getEventOut(fractionFieldName);
	}
	
	public void setFractionChanged(float value) {
		getFractionChangedField().setValue(value);
	}

	public void setFractionChanged(String value) {
		getFractionChangedField().setValue(value);
	}

	public float getFractionChanged() {
		return getFractionChangedField().getValue();
	}
	
	public ConstSFFloat getFractionField() {
		return getFractionChangedField();
	}

	public void setFraction(float value) {
		setFractionChanged(value);
	}

	public void setFraction(String value) {
		setFractionChanged(value);
	}

	public float getFraction() {
		return getFractionChanged();
	}
	
	////////////////////////////////////////////////
	//	Cycle time
	////////////////////////////////////////////////

	public ConstSFTime getCycleTimeField() {
		if (isInstanceNode() == false)
			return cycleTimeField;
		return (ConstSFTime)getEventOut(cycleTimeFieldName);
	}
	
	public void setCycleTime(double value) {
		getCycleTimeField().setValue(value);
	}

	public void setCycleTime(String value) {
		getCycleTimeField().setValue(value);
	}
	
	public double getCycleTime() {
		return getCycleTimeField().getValue();
	}
	
	////////////////////////////////////////////////
	//	Time
	////////////////////////////////////////////////

	public ConstSFTime getTimeField() {
		if (isInstanceNode() == false)
			return timeField;
		return (ConstSFTime)getEventOut(timeFieldName);
	}
	
	public void setTime(double value) {
		getTimeField().setValue(value);
	}

	public void setTime(String value) {
		getTimeField().setValue(value);
	}
	
	public double getTime() {
		return getTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
		setCycleTime(-1.0f);
		setIsActive(false);
		setRunnableIntervalTime((int)(getCycleInterval() * 1000));
	}

	public void uninitialize() {
	}

	public double getCurrentSystemTime() {
		Date date = new Date();
		return (double)date.getTime() / 1000.0;
	}
	
	private double currentTime = 0;
	
	public void update() {

		double startTime = getStartTime();
		double stopTime = getStopTime();
		double cycleInterval = getCycleInterval();

		boolean bActive	= isActive();
		boolean bEnable	= isEnabled();
		boolean bLoop		= isLoop();

		if (currentTime == 0)
			currentTime = getCurrentSystemTime();

		// isActive 
		if (bEnable == false && bActive == true) {
			setIsActive(false);
			sendEvent(getIsActiveField());
			return;
		}

		if (bActive == false && bEnable == true) {
			if (startTime <= currentTime) {
				if (bLoop == true && stopTime <= startTime)
					bActive = true;
				else if (bLoop == false && stopTime <= startTime)
					bActive = true;
				else if (currentTime <= stopTime) {
					if (bLoop == true && startTime < stopTime)
						bActive = true;
					else if	(bLoop == false && startTime < (startTime + cycleInterval) && (startTime + cycleInterval) <= stopTime)
						bActive = true;
					else if (bLoop == false && startTime < stopTime && stopTime < (startTime + cycleInterval))
						bActive = true;
				}
			}
			if (bActive) {
				setIsActive(true);
				sendEvent(getIsActiveField());
				setCycleTime(currentTime);
				sendEvent(getCycleTimeField());
			}
		}

		currentTime = getCurrentSystemTime();
	
		if (bActive == true && bEnable == true) {
			if (bLoop == true && startTime < stopTime) {
				if (stopTime < currentTime)
					bActive = false;
			}
			else if (bLoop == false && stopTime <= startTime) {
				if (startTime + cycleInterval < currentTime)
					bActive = false;
			}
			else if (bLoop == false && startTime < (startTime + cycleInterval) && (startTime + cycleInterval) <= stopTime) {
				if (startTime + cycleInterval < currentTime)
					bActive = false;
			}
			else if (bLoop == false && startTime < stopTime && stopTime < (startTime + cycleInterval)) {
				if (stopTime < currentTime)
					bActive = false;
			}

			if (bActive == false) {
				setIsActive(false);
				sendEvent(getIsActiveField());
			}
		}

		if (bEnable == false || isActive() == false)
			return;

		// fraction_changed 
		double	fraction = (currentTime - startTime) % cycleInterval;
		if (fraction == 0.0 && startTime < currentTime)
			fraction = 1.0;
		else
			fraction /= cycleInterval;
		setFractionChanged((float)fraction);
		sendEvent(getFractionChangedField());

		// cycleTime
		double	cycleTime		= getCycleTime();
		double	cycleEndTime	= cycleTime + cycleInterval;
		while (cycleEndTime < currentTime) {
			setCycleTime(cycleEndTime);
			cycleEndTime += cycleInterval;
			setCycleTime(currentTime);
			sendEvent(getCycleTimeField());
		}

		// time
		setTime(currentTime);
		sendEvent(getTimeField());
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool bEnabled = getEnabledField();
		SFBool loop = getLoopField();

		printStream.println(indentString + "\t" + "cycleInterval " + getCycleInterval() );
		printStream.println(indentString + "\t" + "enabled " + bEnabled );
		printStream.println(indentString + "\t" + "loop " + loop );
		printStream.println(indentString + "\t" + "startTime " + getStartTime() );
		printStream.println(indentString + "\t" + "stopTime " + getStopTime() );
	}
}
