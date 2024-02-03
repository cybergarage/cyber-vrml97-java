/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Collision.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class CollisionNode extends GroupingNode {

	private String	collideFieldName		= "collide";
	private String	collideTimeEventOut		= "collideTime";

	private 	SFBool collideField;
	private	ConstSFTime collideTimeField;
	
	public CollisionNode() {
		super();

		setHeaderFlag(false);
		setType(collisionTypeName);

		// collide exposed field
		collideField = new SFBool(true);
		addExposedField(collideFieldName, collideField);

		// collide event out
		collideTimeField = new ConstSFTime(-1.0);
		addEventOut(collideTimeEventOut, collideTimeField);
	}

	public CollisionNode(CollisionNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	collide
	////////////////////////////////////////////////

	public SFBool getCollideField() {
		if (isInstanceNode() == false)
			return collideField;
		return (SFBool)getExposedField(collideFieldName);
	}

	public void setCollide(boolean value) {
		getCollideField().setValue(value);
	}

	public void setCollide(String value) {
		getCollideField().setValue(value);
	}

	public boolean getCollide() {
		return getCollideField().getValue();
	}

	////////////////////////////////////////////////
	//	collideTime
	////////////////////////////////////////////////

	public ConstSFTime getCollideTimeField() {
		if (isInstanceNode() == false)
			return collideTimeField;
		return (ConstSFTime)getEventOut(collideTimeEventOut);
	}

	public void setCollideTime(double value) {
		getCollideTimeField().setValue(value);
	}

	public void setCollideTime(String value) {
		getCollideTimeField().setValue(value);
	}

	public double getCollideTime() {
		return getCollideTimeField().getValue();
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		if (node.isCommonNode() || node.isBindableNode() ||node.isInterpolatorNode() || node.isSensorNode() || node.isGroupingNode() || node.isSpecialGroupNode())
			return true;
		else
			return false;
	}

	public void initialize() {
		super.initialize();
		updateChildrenField();
		calculateBoundingBox();
	}

	public void uninitialize() {
	}

	public void update() {
		//updateChildrenField();
		//calculateBoundingBox();
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		SFBool collide = getCollideField();
		printStream.println(indentString + "\t" + "collide " + collide);
	}
}
