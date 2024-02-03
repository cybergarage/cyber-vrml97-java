/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Coordinate.java
*
******************************************************************/

package cv97.node;

import java.util.Vector;
import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class CoordinateNode extends Node {

	private String	pointFieldName = "point";

	private MFVec3f pointField;
	
	public CoordinateNode() {
		setHeaderFlag(false);
		setType(coordinateTypeName);

		// point exposed field
		pointField = new MFVec3f();
		pointField.setName(pointFieldName);
		addExposedField(pointField);
	}

	public CoordinateNode(CoordinateNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	point 
	////////////////////////////////////////////////

	public MFVec3f getPointField() {
		if (isInstanceNode() == false)
			return pointField;
		return (MFVec3f)getExposedField(pointFieldName);
	}

	public void addPoint(float point[]) {
		getPointField().addValue(point);
	}

	public void addPoint(float x, float y, float z) {
		getPointField().addValue(x, y, z);
	}

	public int getNPoints() {
		return getPointField().getSize();
	}

	public void setPoint(int index, float point[]) {
		getPointField().set1Value(index, point);
	}

	public void setPoint(int index, float x, float y, float z) {
		getPointField().set1Value(index, x, y, z);
	}

	public void setPoints(String value) {
		getPointField().setValues(value);
	}

	public void setPoints(String value[]) {
		getPointField().setValues(value);
	}

	public void getPoint(int index, float point[]) {
		getPointField().get1Value(index, point);
	}

	public float[] getPoint(int index) {
		float value[] = new float[3];
		getPoint(index, value);
		return value;
	}

	public void removePoint(int index) {
		getPointField().removeValue(index);
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		return false;
	}

	public void initialize() {
		super.initialize();
	}

	public void uninitialize() {
	}

	public void update() {
	}

	////////////////////////////////////////////////
	//	Output
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		float point[] = new float[3];
		printStream.println(indentString + "\tpoint [");
		for (int n=0; n<getNPoints(); n++) {
			getPoint(n, point);
			if (n < getNPoints()-1)
				printStream.println(indentString + "\t\t" + point[X] + " " + point[Y] + " " + point[Z] + ",");
			else	
				printStream.println(indentString + "\t\t" + point[X] + " " + point[Y] + " " + point[Z]);
		}
		printStream.println(indentString + "\t]");
	}
}