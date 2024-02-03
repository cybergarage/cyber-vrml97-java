/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: BindableNode.java
*
******************************************************************/

package cv97.node;

import cv97.*;
import cv97.field.*;

public abstract class BindableNode extends Node {

	private String	setBindFieldString			= "bind";
	private String	bindTimeFieldString			= "bindTime";
	private String	isBoundFieldString			= "isBound";

	private SFBool setBindField;
	private 	ConstSFTime bindTimeField;
	private 	ConstSFBool isBoundField;

	public BindableNode() {
		setHeaderFlag(false);

		// set_bind
		setBindField = new SFBool(true);
		addEventIn(setBindFieldString, setBindField);

		// cybleInterval exposed field
		bindTimeField = new ConstSFTime(1.0);
		addEventOut(bindTimeFieldString, bindTimeField);

		// isBind
		isBoundField = new ConstSFBool(true);
		addEventOut(isBoundFieldString, isBoundField);
	}

	////////////////////////////////////////////////
	//	bind
	////////////////////////////////////////////////

	public SFBool getBindField() {
		if (isInstanceNode() == false)
			return setBindField;
		return (SFBool)getEventIn(setBindFieldString);
	}

	public void setBind(boolean value) {
		getBindField().setValue(value);
	}

	public void setBind(String value) {
		getBindField().setValue(value);
	}
	
	public boolean getBind() {
		return getBindField().getValue();
	}
	
	////////////////////////////////////////////////
	//	bindTime
	////////////////////////////////////////////////
	
	public ConstSFTime getBindTimeField() {
		if (isInstanceNode() == false)
			return bindTimeField;
		return (ConstSFTime)getEventOut(bindTimeFieldString);
	}

	public void setBindTime(double value) {
		getBindTimeField().setValue(value);
	}

	public void setBindTime(String value) {
		getBindTimeField().setValue(value);
	}
	
	public double getBindTime() {
		return getBindTimeField().getValue();
	}
	
	////////////////////////////////////////////////
	//	isBound
	////////////////////////////////////////////////

	public ConstSFBool getIsBoundField() {
		if (isInstanceNode() == false)
			return isBoundField;
		return (ConstSFBool)getEventOut(isBoundFieldString);
	}

	public void setIsBound(boolean value) {
		getIsBoundField().setValue(value);
	}

	public void setIsBound(String value) {
		getIsBoundField().setValue(value);
	}
	
	public boolean getIsBound() {
		return getIsBoundField().getValue();
	}
	
	public boolean isBound() {
		return getIsBound();
	}
	
}

