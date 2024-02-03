/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : SFBool.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class SFBool extends Field {

	private BoolValue mValue = new BoolValue(true); 

	public SFBool() {
		setType(fieldTypeSFBool);
		setValue(true);
	}

	public SFBool(SFBool value) {
		setType(fieldTypeSFBool);
		setValue(value);
	}

	public SFBool(ConstSFBool value) {
		setType(fieldTypeSFBool);
		setValue(value);
	}

	public SFBool(boolean value) {
		setType(fieldTypeSFBool);
		setValue(value);
	}

	public SFBool(String value) {
		setType(fieldTypeSFBool);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	set*
	////////////////////////////////////////////////

	public void setValue(boolean value, boolean doShare) {
		synchronized (mValue) {
			mValue.setValue(value);
		}
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(boolean value) {
		 setValue(value, true);
	}

	public void setValue(SFBool value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(SFBool value) {
		setValue(value, true);
	}

	public void setValue(ConstSFBool value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(ConstSFBool value) {
		setValue(value, true);
	}

	public void setValue(String value) {
		if (value.equalsIgnoreCase("TRUE") == true)
			setValue(true);
		else
			setValue(false);
	}

	public void setValue(Field field, boolean doShare) {
		if (field instanceof SFBool)
			setValue((SFBool)field, doShare);
		if (field instanceof ConstSFBool)
			setValue((ConstSFBool)field, doShare);
	}

	public void setValue(Field field) {
		setValue(field, true);
	}

	////////////////////////////////////////////////
	//	get*
	////////////////////////////////////////////////

	public boolean getValue() {
		boolean value;
		synchronized (mValue) {
			value = mValue.getValue();
		}
		return value;
	}

	////////////////////////////////////////////////
	//	Object
	////////////////////////////////////////////////

	public void setObject(Object object) {
		synchronized (mValue) {
			mValue = (BoolValue)object;
		}
	}

	public Object getObject() {
		Object object;
		synchronized (mValue) {
			object = mValue;
		}
		return object;
	}
	
	////////////////////////////////////////////////
	//	toString
	////////////////////////////////////////////////

	public String toString() {
		if (getValue() == true)
			return "TRUE";
		else
			return "FALSE";
	}

	public String toXMLString()
	{
		if (getValue() == true)
			return "true";
		else
			return "false";
	}
}