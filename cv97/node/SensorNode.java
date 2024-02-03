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

public abstract class SensorNode extends Node {
	
	private String	enabledFieldName		= "enabled";

	private SFBool enabledField;
	private ConstSFBool isActiveField;

	public SensorNode() {
	
		// enabled exposed field
		enabledField = new SFBool(true);
		addExposedField(enabledFieldName, enabledField);

		// isActive eventOut field
		isActiveField = new ConstSFBool(false);
		addEventOut(isActiveFieldName, isActiveField);
	}

	////////////////////////////////////////////////
	//	Enabled
	////////////////////////////////////////////////

	public SFBool getEnabledField() {
		if (isInstanceNode() == false)
			return enabledField;
		return (SFBool)getExposedField(enabledFieldName);
	}
	
	public void setEnabled(boolean value) {
		getEnabledField().setValue(value);
	}

	public void setEnabled(String value) {
		getEnabledField().setValue(value);
	}
	
	public boolean getEnabled() {
		return getEnabledField().getValue();
	}
	
	public boolean isEnabled() {
		return getEnabled();
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
		return getIsActive();
	}

}
