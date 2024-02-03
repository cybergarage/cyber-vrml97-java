/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFString.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class ConstSFString extends ConstField {

	private StringValue mValue = new StringValue(null); 

	public ConstSFString() {
		setType(fieldTypeConstSFString);
	}

	public ConstSFString(SFString string) {
		setType(fieldTypeConstSFString);
		setValue(string);
	}

	public ConstSFString(ConstSFString string) {
		setType(fieldTypeConstSFString);
		setValue(string);
	}

	public ConstSFString(String value) {
		setType(fieldTypeConstSFString);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	set*
	////////////////////////////////////////////////

	public void setValue(String value, boolean doShare) {
		synchronized (mValue) {
			mValue.setValue(value);
		}
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(String value) {
		setValue(value, true);
	}

	public void setValue(SFString value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(ConstSFString value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(SFString value) {
		setValue(value, true);
	}

	public void setValue(ConstSFString value) {
		setValue(value, true);
	}

	public void setValue(Field field, boolean doShare) {
		if (field instanceof SFString)
			setValue((SFString)field, doShare);
		if (field instanceof ConstSFString)
			setValue((ConstSFString)field, doShare);
	}

	public void setValue(Field field) {
		setValue(field, true);
	}

	////////////////////////////////////////////////
	//	get*
	////////////////////////////////////////////////
	
	public String getValue() {
		String value;
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
			mValue = (StringValue)object;
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
		return "\"" + getValue() + "\"";
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFString field = new SFString();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
	
	public String toXMLString()
	{
		String value = getValue();
		if (value == null)
			return "";
		return value;
	}
}