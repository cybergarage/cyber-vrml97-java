/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : SFTime.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class SFTime extends Field {

	private DoubleValue mValue = new DoubleValue(0); 
	
	public SFTime() {
		setType(fieldTypeSFTime);
		setValue(-1);
	}

	public SFTime(SFTime time) {
		setType(fieldTypeSFTime);
		setValue(time);
	}

	public SFTime(ConstSFTime time) {
		setType(fieldTypeSFTime);
		setValue(time);
	}

	public SFTime(double value) {
		setType(fieldTypeSFTime);
		setValue(value);
	}

	public SFTime(String value) {
		setType(fieldTypeSFTime);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	set*
	////////////////////////////////////////////////
	
	public void setValue(double value, boolean doShare) {
		synchronized (mValue) {
			mValue.setValue(value);
		}
		if (doShare == true)
			postShareField(this);
	}
	
	public void setValue(double value) {
		setValue(value, true);
	}

	public void setValue(SFTime value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(ConstSFTime value, boolean doShare) {
		setValue(value.getValue(), doShare);
	}

	public void setValue(SFTime value) {
		setValue(value, true);
	}

	public void setValue(ConstSFTime value) {
		setValue(value, true);
	}

	public void setValue(String value) {
		try {
			Double dvalue = new Double(value);
			setValue(dvalue.doubleValue());
		}
		catch (NumberFormatException e) {}
	}

	public void setValue(Field field, boolean doShare) {
		if (field instanceof SFTime)
			setValue((SFTime)field);
		if (field instanceof ConstSFTime)
			setValue((ConstSFTime)field);
	}

	public void setValue(Field field) {
		setValue(field, true);
	}

	////////////////////////////////////////////////
	//	get*
	////////////////////////////////////////////////

	public double getValue() {
		double value;
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
			mValue = (DoubleValue)object;
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
		Double value = new Double(getValue());
		return value.toString();
	}
}