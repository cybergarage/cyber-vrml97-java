/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Normal.java
*
******************************************************************/

package cv97.node;

import java.util.Vector;
import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class NormalNode extends Node {

	private String	vectorFieldName = "vector";

	private MFVec3f vectorField;

	public NormalNode () {
		setHeaderFlag(false);
		setType(normalTypeName);

		// vector exposed field
		vectorField = new MFVec3f();
		vectorField.setName(vectorFieldName);
		addExposedField(vectorField);
	}

	public NormalNode(NormalNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	vector
	////////////////////////////////////////////////

	public MFVec3f getVectorField() {
		if (isInstanceNode() == false)
			return vectorField;
		return (MFVec3f)getExposedField(vectorFieldName);
	}
	
	public void addVector(float value[]) {
		getVectorField().addValue(value);
	}
	
	public void addVector(float x, float y, float z) {
		getVectorField().addValue(x, y, z);
	}
	
	public int getNVectors() {
		return getVectorField().getSize();
	}
	
	public void setVector(int index, float value[]) {
		getVectorField().set1Value(index, value);
	}
	
	public void setVector(int index, float x, float y, float z) {
		getVectorField().set1Value(index, x, y, z);
	}

	public void setVectors(String value) {
		getVectorField().setValues(value);
	}

	public void setVectors(String value[]) {
		getVectorField().setValues(value);
	}
	
	public void getVector(int index, float value[]) {
		getVectorField().get1Value(index, value);
	}
	
	public float[] getVector(int index) {
		float value[] = new float[3];
		getVector(index, value);
		return value;
	}
	
	public void removeVector(int index) {
		getVectorField().removeValue(index);
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
		float vector[] = new float[3];
		printStream.println(indentString + "\tvector [");
		for (int n=0; n<getNVectors(); n++) {
			getVector(n, vector);
			if (n < getNVectors()-1)
				printStream.println(indentString + "\t\t" + vector[X] + " " + vector[Y] + " " + vector[Z] + ",");
			else	
				printStream.println(indentString + "\t\t" + vector[X] + " " + vector[Y] + " " + vector[Z]);
		}
		printStream.println(indentString + "\t]");
	}

	////////////////////////////////////////////////
	//	List
	////////////////////////////////////////////////

/* for Visual C++
	public Normal next() {
		return (Normal)next(getType());
	}

	public Normal nextTraversal() {
		return (Normal)nextTraversalByType(getType());
	}
*/

}