/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: GroupingNode.java
*
******************************************************************/

package cv97.node;

import cv97.*;
import cv97.util.*;
import cv97.field.*;

public abstract class GroupingNode extends Node {

	private String	addChildrenEventIn		= "addChildren";
	private String	removeChildrenEventIn	= "removeChildren";
	private String	childrenExposedField		= "children";
	
	private String	bboxCenterFieldName		= "bboxCenter";
	private String	bboxSizeFieldName			= "bboxSize";

	private MFNode addChildrenField;
	private MFNode removeChildrenField;
	private MFNode childrenField;
	
	private SFVec3f bboxCenterField;
	private SFVec3f bboxSizeField;

	public GroupingNode(boolean bAddChildrenField, boolean bAddBBoxField) {
		setHeaderFlag(false);

		if (bAddChildrenField == true) {
			// addChildren eventout field
			addChildrenField = new MFNode();
			addEventIn(addChildrenEventIn, addChildrenField);

			// removeChildren eventout field
			removeChildrenField = new MFNode();
			addEventIn(removeChildrenEventIn, removeChildrenField);

			// children exposedField
			childrenField = new MFNode();
			addExposedField(childrenExposedField, childrenField);
		}
		
		if (bAddBBoxField == true) {
			// bboxBBoxCenter field
			bboxCenterField = new SFVec3f(0.0f, 0.0f, 0.0f);
			bboxCenterField.setName(bboxCenterFieldName);
			addField(bboxCenterField);

			// bboxSize field
			bboxSizeField = new SFVec3f(-1.0f, -1.0f, -1.0f);
			bboxSizeField.setName(bboxSizeFieldName);
			addField(bboxSizeField);
		}
	}

	public GroupingNode() {
		this(true);
	}

	public GroupingNode(boolean bAddChildrenField) {
		this(bAddChildrenField, true);
	}

	////////////////////////////////////////////////
	//	addChildren / removeChildren
	////////////////////////////////////////////////

	public MFNode getAddChildrenField() {
		if (isInstanceNode() == false)
			return addChildrenField;
		return (MFNode)getEventIn(addChildrenEventIn);
	}

	public MFNode getRemoveChildrenField() {
		if (isInstanceNode() == false)
			return removeChildrenField;
		return (MFNode)getEventIn(removeChildrenEventIn);
	}

	////////////////////////////////////////////////
	//	children
	////////////////////////////////////////////////

	public MFNode getChildrenField() {
		if (isInstanceNode() == false)
			return childrenField;
		return (MFNode)getExposedField(childrenExposedField);
	}

	public void updateChildrenField() {
		MFNode childrenField = getChildrenField();
		childrenField.removeAllValues();
		for (Node node=getChildNodes(); node != null; node=node.next()) 
			childrenField.addValue(node);
	}

	////////////////////////////////////////////////
	//	BBoxSize
	////////////////////////////////////////////////

	public SFVec3f getBoundingBoxSizeField() {
		if (isInstanceNode() == false)
			return bboxSizeField;
		return (SFVec3f)getField(bboxSizeFieldName);
	}

	public void setBoundingBoxSize(float value[]) {
		getBoundingBoxSizeField().setValue(value);
	}
	
	public void setBoundingBoxSize(float x, float y, float z) {
		getBoundingBoxSizeField().setValue(x, y, z);
	}
	
	public void setBoundingBoxSize(String value) {
		getBoundingBoxSizeField().setValue(value);
	}
	
	public void getBoundingBoxSize(float value[]) {
		getBoundingBoxSizeField().getValue(value);
	}

	public float[] getBoundingBoxSize() {
		float size[] = new float[3];
		getBoundingBoxSize(size);
		return size;
	}

	////////////////////////////////////////////////
	//	BBoxCenter
	////////////////////////////////////////////////

	public SFVec3f getBoundingBoxCenterField() {
		if (isInstanceNode() == false)
			return bboxCenterField;
		return (SFVec3f)getField(bboxCenterFieldName);
	}

	public void setBoundingBoxCenter(float value[]) {
		getBoundingBoxCenterField().setValue(value);
	}
	
	public void setBoundingBoxCenter(float x, float y, float z) {
		getBoundingBoxCenterField().setValue(x, y, z);
	}
	
	public void setBoundingBoxCenter(String value) {
		getBoundingBoxCenterField().setValue(value);
	}
	
	public void getBoundingBoxCenter(float value[]) {
		getBoundingBoxCenterField().getValue(value);
	}

	public float[] getBoundingBoxCenter() {
		float center[] = new float[3];
		getBoundingBoxCenter(center);
		return center;
	}

	////////////////////////////////////////////////
	//	abstract method
	////////////////////////////////////////////////
	
	public void updateBoundingBox(Node node, BoundingBox bbox) {
		if (node.isGeometryNode() == true) {
			GeometryNode gnode = (GeometryNode)node;
			gnode.calculateBoundingBox();

			float bboxCenter[]	= new float[3];
			float bboxSize[]	= new float[3];
			float point[]		= new float[3];

			gnode.getBoundingBoxCenter(bboxCenter);
			gnode.getBoundingBoxSize(bboxSize);
						
			if (bboxSize[0] >= 0.0f && bboxSize[1] >= 0.0f && bboxSize[2] >= 0.0f) {
				SFMatrix mx = gnode.getTransformMatrix();
				for (int n=0; n<8; n++) {
					point[0] = (n < 4)			? bboxCenter[0] - bboxSize[0] : bboxCenter[0] + bboxSize[0];
					point[1] = ((n % 2) != 0)	? bboxCenter[1] - bboxSize[1] : bboxCenter[1] + bboxSize[1];
					point[2] = ((n % 4) < 2)	? bboxCenter[2] - bboxSize[2] : bboxCenter[2] + bboxSize[2];
					mx.multi(point);
					bbox.addPoint(point);
				}
			}
		}
		
		for (Node cnode=node.getChildNodes(); cnode != null; cnode=cnode.next())
			updateBoundingBox(cnode, bbox);
	}
	
	public void calculateBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		for (Node node=getChildNodes(); node != null; node=node.next())
			updateBoundingBox(node, bbox);
		setBoundingBoxCenter(bbox.getCenter());
		setBoundingBoxSize(bbox.getSize());
	}
}
