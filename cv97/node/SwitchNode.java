/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Switch.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class SwitchNode extends GroupingNode {

	private String	whichChoiceFieldName	= "whichChoice";
	private String	choiceExposedField		= "choice";

	private SFInt32	whichChoiceField;
	private MFNode	choiceField;
	
	public SwitchNode() {
		super(false, false);
		setHeaderFlag(false);
		setType(switchTypeName);

		// whichChoice field
		whichChoiceField = new SFInt32(-1);
		addField(whichChoiceFieldName, whichChoiceField);

		// choice exposedField
		choiceField = new MFNode();
		addExposedField(choiceExposedField, choiceField);
	}

	public SwitchNode(SwitchNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	whichChoice
	////////////////////////////////////////////////

	public SFInt32 getWhichChoiceField() {
		if (isInstanceNode() == false)
			return whichChoiceField;
		return (SFInt32)getField(whichChoiceFieldName);
	}

	public void setWhichChoice(int value) {
		getWhichChoiceField().setValue(value);
	}

	public void setWhichChoice(String value) {
		getWhichChoiceField().setValue(value);
	}

	public int getWhichChoice() {
		return getWhichChoiceField().getValue();
	}

	////////////////////////////////////////////////
	//	choice
	////////////////////////////////////////////////

	public MFNode getChoiceField() {
		if (isInstanceNode() == false)
			return choiceField;
		return (MFNode)getExposedField(choiceExposedField);
	}

	public void updateChoiceField() {
		MFNode choiceField = getChoiceField();
		choiceField.removeAllValues();
		for (Node node=getChildNodes(); node != null; node=node.next()) 
			choiceField.addValue(node);
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
		updateChoiceField();
		//calculateBoundingBox();
	}

	public void uninitialize() {
	}

	public void update() {
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		printStream.println(indentString + "\t" + "whichChoice " + getWhichChoice());
	}
}
