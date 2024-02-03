/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFInt32.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class ConstSFInt32 extends ConstField {

	private IntValue mValue = new IntValue(0); 

	public ConstSFInt32() {
		setType(fieldTypeConstSFInt32);
		setValue(0);
	}

	public ConstSFInt32(SFInt32 value) {
		setType(fieldTypeConstSFInt32);
		setValue(value);
	}

	public ConstSFInt32(ConstSFInt32 value) {
		setType(fieldTypeConstSFInt32);
		setValue(value);
	}

	public ConstSFInt32(int value) {
		setType(fieldTypeConstSFInt32);
		setValue(value);
	}

	public ConstSFInt32(String value) {
		setType(fieldTypeConstSFInt32);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	set*
	////////////////////////////////////////////////

	public void setValue(int value, boolean doShare) {
		synchronized (mValue) {
			mValue.setValue(value);
		}
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(int value) {
		setValue(value, true);
	}

	public void setValue(SFInt32 value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(SFInt32 value) {
		setValue(value, true);
	}

	public void setValue(ConstSFInt32 value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(ConstSFInt32 value) {
		setValue(value, true);
	}

	public void setValue(String value) {
		try {
			Float ivalue = new Float(value);
			setValue(ivalue.intValue());
		}
		catch (NumberFormatException e) {}
	}

	public void setValue(Field field, boolean doShare) {
		if (field instanceof SFInt32)
			setValue((SFInt32)field, doShare);
		if (field instanceof ConstSFInt32)
			setValue((ConstSFInt32)field, doShare);
	}

	public void setValue(Field field) {
		setValue(field, true);
	}

	////////////////////////////////////////////////
	//	get*
	////////////////////////////////////////////////

	public int getValue() {
		int value;
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
			mValue = (IntValue)object;
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
		Integer value = new Integer(getValue());
		return value.toString();
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFInt32 field = new SFInt32();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
}