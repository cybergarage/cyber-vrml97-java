/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : TextureCoordinate.java
*
******************************************************************/

package cv97.node;

import java.util.Vector;
import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class TextureCoordinateNode extends Node {
	
	private String	pointFieldName = "point";

	private MFVec2f pointField;
	
	public TextureCoordinateNode() {
		setHeaderFlag(false);
		setType(textureCoordinateTypeName);

		// point exposed field
		pointField = new MFVec2f();
		pointField.setName(pointFieldName);
		addExposedField(pointField);
	}

	public TextureCoordinateNode(TextureCoordinateNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	point 
	////////////////////////////////////////////////

	public MFVec2f getPointField() {
		if (isInstanceNode() == false)
			return pointField;
		return (MFVec2f)getExposedField(pointFieldName);
	}

	public void addPoint(float point[]) {
		getPointField().addValue(point);
	}

	public void addPoint(float x, float y) {
		getPointField().addValue(x, y);
	}

	public int getNPoints() {
		return getPointField().getSize();
	}

	public void setPoint(int index, float point[]) {
		getPointField().set1Value(index, point);
	}

	public void setPoint(int index, float x, float y) {
		getPointField().set1Value(index, x, y);
	}

	public void setPoints(String point) {
		getPointField().setValues(point);
	}

	public void setPoints(String point[]) {
		getPointField().setValues(point);
	}

	public void getPoint(int index, float point[]) {
		getPointField().get1Value(index, point);
	}

	public float[] getPoint(int index) {
		float value[] = new float[2];
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
		float point[] = new float[2];
		printStream.println(indentString + "\tpoint [");
		for (int n=0; n<getNPoints(); n++) {
			getPoint(n, point);
			if (n < getNPoints()-1)
				printStream.println(indentString + "\t\t" + point[X] + " " + point[Y] +  ",");
			else	
				printStream.println(indentString + "\t\t" + point[X] + " " + point[Y]);
		}
		printStream.println(indentString + "\t]");
	}
}