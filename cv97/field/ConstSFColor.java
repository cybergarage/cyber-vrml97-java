/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFColor.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class ConstSFColor extends ConstField {

	private ColorValue mValue = new ColorValue(); 

	public ConstSFColor() {
		setType(fieldTypeConstSFColor);
		setValue(1.0f, 1.0f, 1.0f);
	}

	public ConstSFColor(SFColor color) {
		setType(fieldTypeConstSFColor);
		setValue(color);
	}

	public ConstSFColor(ConstSFColor color) {
		setType(fieldTypeConstSFColor);
		setValue(color);
	}

	public ConstSFColor(float r, float g, float b) {
		setType(fieldTypeConstSFColor);
		setValue(r, g, b);
	}

	public ConstSFColor(float value[]) {
		setType(fieldTypeConstSFColor);
		setValue(value);
	}

	public ConstSFColor(String value) {
		setType(fieldTypeConstSFColor);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	Object
	////////////////////////////////////////////////

	public void setObject(Object object) {
		synchronized (mValue) {
			mValue = (ColorValue)object;
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
	//	get value
	////////////////////////////////////////////////

	public void getValue(float value[]) 
	{
		mValue.getValue(value);
	}

	public float[] getValue() 
	{
		return mValue.getValue();
	}

	public float getRed() 
	{
		return mValue.getRed();
	}

	public float getGreen() 
	{
		return mValue.getGreen();
	}

	public float getBlue() 
	{
		return mValue.getBlue();
	}

	////////////////////////////////////////////////
	//	set value
	////////////////////////////////////////////////

	public void setValue(float r, float g, float b, boolean doShare) 
	{
		mValue.setValue(r, g, b);
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(float r, float g, float b) 
	{
		setValue(r, g, b, true);
	}

	public void setValue(float value[]) 
	{
		if (value.length < 3)
			return;
		setValue(value[0], value[1], value[2]);
	}

	public void setValue(SFColor color, boolean doShare) 
	{
		setValue(color.getRed(), color.getGreen(), color.getBlue(), doShare);
	}

	public void setValue(ConstSFColor color, boolean doShare) 
	{
		setValue(color.getRed(), color.getGreen(), color.getBlue(), doShare);
	}

	public void setValue(SFColor color)
	{
		setValue(color, true);
	}

	public void setValue(ConstSFColor color) 
	{
		setValue(color, true);
	}

	public void setValue(String string) 
	{
		mValue.setValue(string);
	}

	public void setValue(Field field, boolean doShare) 
	{
		if (field instanceof SFColor)
			setValue((SFColor)field, doShare);
		if (field instanceof ConstSFColor)
			setValue((ConstSFColor)field, doShare);
	}

	public void setValue(Field field) 
	{
		setValue(field, true);
	}
	
	////////////////////////////////////////////////
	//	add value
	////////////////////////////////////////////////

	public void add(float r, float g, float b) 
	{
		mValue.add(r, g, b);
	}

	public void add(float value[]) 
	{
		mValue.add(value);
	}

	public void add(SFColor value) 
	{
		add(value.getValue());
	}

	////////////////////////////////////////////////
	//	sub value
	////////////////////////////////////////////////

	public void sub(float r, float g, float b) 
	{
		mValue.sub(r, g, b);
	}

	public void sub(float value[]) 
	{
		mValue.sub(value);
	}

	public void sub(SFColor value) 
	{
		sub(value.getValue());
	}

	////////////////////////////////////////////////
	//	scale
	////////////////////////////////////////////////

	public void scale(float scale) 
	{
		mValue.scale(scale);
	}

	////////////////////////////////////////////////
	//	toString
	////////////////////////////////////////////////

	public String toString() {
		return getRed() + " " + getGreen() + " " + getBlue();
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFColor field = new SFColor();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
}