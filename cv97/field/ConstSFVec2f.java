/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFVec2f.java
*
******************************************************************/

package cv97.field;

import cv97.*;

public class ConstSFVec2f extends ConstField {

	private Vector2Value mVector = new Vector2Value(); 

	public ConstSFVec2f() {
		setType(fieldTypeConstSFVec2f);
		setValue(0.0f, 0.0f);
	}

	public ConstSFVec2f(SFVec2f vector) {
		setType(fieldTypeConstSFVec2f);
		setValue(vector);
	}

	public ConstSFVec2f(ConstSFVec2f vector) {
		setType(fieldTypeConstSFVec2f);
		setValue(vector);
	}

	public ConstSFVec2f(float x, float y) {
		setType(fieldTypeConstSFVec2f);
		setValue(x, y);
	}

	public ConstSFVec2f(float value[]) {
		setType(fieldTypeConstSFVec2f);
		setValue(value);
	}

	public ConstSFVec2f(String value) {
		setType(fieldTypeConstSFVec2f);
		setValue(value);
	}

	////////////////////////////////////////////////
	//	Object
	////////////////////////////////////////////////

	public void setObject(Object object) {
		synchronized (mVector) {
			mVector = (Vector2Value)object;
		}
	}

	public Object getObject() {
		Object object;
		synchronized (mVector) {
			object = mVector;
		}
		return object;
	}
	
	////////////////////////////////////////////////
	//	get value
	////////////////////////////////////////////////

	public void getValue(float value[]) 
	{
		mVector.getValue(value);
	}

	public float[] getValue() 
	{
		return mVector.getValue();
	}

	public float getX() 
	{
		return mVector.getX();
	}

	public float getY() 
	{
		return mVector.getY();
	}

	////////////////////////////////////////////////
	//	set value
	////////////////////////////////////////////////

	public void setValue(float x, float y, boolean doShare) 
	{
		mVector.setValue(x, y);
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(float x, float y) 
	{
		setValue(x, y, true);
	}

	public void setValue(float value[]) 
	{
		if (value.length < 2)
			return;
		setValue(value[0], value[1]);
	}

	public void setValue(SFVec2f vector, boolean doShare) 
	{
		setValue(vector.getX(), vector.getY(), doShare);
	}

	public void setValue(ConstSFVec2f vector, boolean doShare) 
	{
		setValue(vector.getX(), vector.getY(), doShare);
	}

	public void setValue(SFVec2f vector) 
	{
		setValue(vector, true);
	}

	public void setValue(ConstSFVec2f vector) 
	{
		setValue(vector, true);
	}

	public void setValue(String string) 
	{
		mVector.setValue(string);
	}

	public void setValue(Field field, boolean doShare) 
	{
		if (field instanceof SFVec2f)
			setValue((SFVec2f)field, doShare);
		if (field instanceof ConstSFVec2f)
			setValue((ConstSFVec2f)field, doShare);
	}

	public void setValue(Field field) 
	{
		setValue(field, true);
	}

	public void setX(float x) {
		setValue(x, getY());
	}

	public void setY(float y) {
		setValue(getX(), y);
	}

	////////////////////////////////////////////////
	//	add value
	////////////////////////////////////////////////

	public void add(float x, float y) 
	{
		mVector.add(x, y);
	}

	public void add(float value[]) 
	{
		mVector.add(value);
	}

	public void add(SFVec2f value) {
		add(value.getValue());
	}

	////////////////////////////////////////////////
	//	sub value
	////////////////////////////////////////////////

	public void sub(float x, float y) 
	{
		mVector.sub(x, y);
	}

	public void sub(float value[]) 
	{
		mVector.sub(value);
	}

	public void sub(SFVec2f value) 
	{
		sub(value.getValue());
	}

	////////////////////////////////////////////////
	//	scale
	////////////////////////////////////////////////

	public void scale(float scale) 
	{
		mVector.scale(scale);
	}

	////////////////////////////////////////////////
	//	invert
	////////////////////////////////////////////////

	public void invert() 
	{
		mVector.invert();
	}

	////////////////////////////////////////////////
	//	scalar
	////////////////////////////////////////////////

	public float getScalar()
	{
		return mVector.getScalar();
	}

	////////////////////////////////////////////////
	//	normalize
	////////////////////////////////////////////////

	public void normalize()
	{
		mVector.normalize();
	}

	////////////////////////////////////////////////
	//	toString
	////////////////////////////////////////////////

	public String toString() {
		return getX() + " " + getY();
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFVec2f field = new SFVec2f();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
}