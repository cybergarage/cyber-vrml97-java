/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFFloat.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class ConstSFFloat extends ConstField {

	private FloatValue mValue = new FloatValue(0.0f); 

	public ConstSFFloat() {
		setType(fieldTypeConstSFFloat);
		setValue(0.0f);
	}

	public ConstSFFloat(SFFloat value) {
		setType(fieldTypeConstSFFloat);
		setValue(value);
	}

	public ConstSFFloat(ConstSFFloat value) {
		setType(fieldTypeConstSFFloat);
		setValue(value);
	}

	public ConstSFFloat(float value) {
		setType(fieldTypeConstSFFloat);
		setValue(value);
	}

	public ConstSFFloat(String value) {
		setType(fieldTypeConstSFFloat);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	set*
	////////////////////////////////////////////////

	public void setValue(float value, boolean doShare) {
		synchronized (mValue) {
			mValue.setValue(value);
		}
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(float value) {
		setValue(value, true);
	}

	public void setValue(SFFloat value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(SFFloat value) {
		setValue(value, true);
	}

	public void setValue(ConstSFFloat value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(ConstSFFloat value) {
		setValue(value, true);
	}

	public void setValue(String value) {
		try {
			Float fvalue = new Float(value);
			setValue(fvalue.floatValue());
		}
		catch (NumberFormatException e) {}
	}

	public void setValue(Field field, boolean doShare) {
		if (field instanceof SFFloat)
			setValue((SFFloat)field, doShare);
		if (field instanceof ConstSFFloat)
			setValue((ConstSFFloat)field, doShare);
	}

	public void setValue(Field field) {
		setValue(field, true);
	}

	////////////////////////////////////////////////
	//	get*
	////////////////////////////////////////////////

	public float getValue() {
		float value;
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
			mValue = (FloatValue)object;
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
		Float value = new Float(getValue());
		return value.toString();
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFFloat field = new SFFloat();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
}