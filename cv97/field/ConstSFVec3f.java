/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : ConstSFVec3f.java
*
******************************************************************/

package cv97.field;

import java.util.StringTokenizer;
import cv97.*;

public class ConstSFVec3f extends ConstField {

	private Vector3Value mVector = new Vector3Value(); 

	public ConstSFVec3f() {
		setType(fieldTypeConstSFVec3f);
		setValue(0.0f, 0.0f, 0.0f);
	}

	public ConstSFVec3f(SFVec3f vector) {
		setType(fieldTypeConstSFVec3f);
		setValue(vector);
	}

	public ConstSFVec3f(ConstSFVec3f vector) {
		setType(fieldTypeConstSFVec3f);
		setValue(vector);
	}

	public ConstSFVec3f(float x, float y, float z) {
		setType(fieldTypeConstSFVec3f);
		setValue(x, y, z);
	}

	public ConstSFVec3f(float value[]) {
		setType(fieldTypeConstSFVec3f);
		setValue(value);
	}

	public ConstSFVec3f(String value) {
		setType(fieldTypeConstSFVec3f);
		setValue(value);
	}


	////////////////////////////////////////////////
	//	Object
	////////////////////////////////////////////////

	public void setObject(Object object) {
		synchronized (mVector) {
			mVector = (Vector3Value)object;
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

	public float getZ() 
	{
		return mVector.getZ();
	}

	////////////////////////////////////////////////
	//	set value
	////////////////////////////////////////////////

	public void setValue(float x, float y, float z, boolean doShare) 
	{
		mVector.setValue(x, y, z);
		if (doShare == true)
			postShareField(this);
	}

	public void setValue(float x, float y, float z) 
	{
		setValue(x, y, z, true);
	}

	public void setValue(float value[]) 
	{
		if (value.length < 3)
			return;
		setValue(value[0], value[1], value[2]);
	}

	public void setValue(SFVec3f vector, boolean doShare) 
	{
		setValue(vector.getX(), vector.getY(), vector.getZ(), doShare);
	}

	public void setValue(ConstSFVec3f vector, boolean doShare) 
	{
		setValue(vector.getX(), vector.getY(), vector.getZ(), doShare);
	}

	public void setValue(SFVec3f vector) 
	{
		setValue(vector, true);
	}

	public void setValue(ConstSFVec3f vector) 
	{
		setValue(vector, true);
	}

	public void setValue(String string) 
	{
		mVector.setValue(string);
	}

	public void setValue(Field field, boolean doShare) 
	{
		if (field instanceof SFVec3f)
			setValue((SFVec3f)field, doShare);
		if (field instanceof ConstSFVec3f)
			setValue((ConstSFVec3f)field, doShare);
	}

	public void setValue(Field field) 
	{
		setValue(field, true);
	}

	public void setX(float x) {
		setValue(x, getY(), getZ());
	}

	public void setY(float y) {
		setValue(getX(), y, getZ());
	}

	public void setZ(float z) {
		setValue(getX(), getY(), z);
	}

	////////////////////////////////////////////////
	//	add value
	////////////////////////////////////////////////

	public void add(float x, float y, float z) 
	{
		mVector.add(x, y, z);
	}

	public void add(float value[]) 
	{
		mVector.add(value);
	}

	public void add(SFVec3f value) {
		add(value.getValue());
	}

	////////////////////////////////////////////////
	//	sub value
	////////////////////////////////////////////////

	public void sub(float x, float y, float z) 
	{
		mVector.sub(x, y, z);
	}

	public void sub(float value[]) 
	{
		mVector.sub(value);
	}

	public void sub(SFVec3f value) 
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
		return getX() + " " + getY() + " " + getZ();
	}

	////////////////////////////////////////////////
	//	Referrence Field Object 
	////////////////////////////////////////////////

	public Field createReferenceFieldObject() {
		SFVec3f field = new SFVec3f();
		field.setName(getName());
		field.setObject(getObject());
		return field;
	}
}