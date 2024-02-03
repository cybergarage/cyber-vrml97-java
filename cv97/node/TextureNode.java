/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File: TextureNode.java
*
******************************************************************/

package cv97.node;

import cv97.*;
import cv97.field.*;

public abstract class TextureNode extends Node {

	private String	repeatSFieldName		= "repeatS";
	private String	repeatTFieldName		= "repeatT";

	private SFBool repeatSField;
	private SFBool repeatTField;

	public TextureNode() {
	
		///////////////////////////
		// Field 
		///////////////////////////

		// repeatS field
		repeatSField = new SFBool(true);
		addField(repeatSFieldName, repeatSField);

		// repeatT field
		repeatTField = new SFBool(true);
		addField(repeatTFieldName, repeatTField);
	}

	////////////////////////////////////////////////
	//	RepeatS
	////////////////////////////////////////////////

	public SFBool getRepeatSField() {
		if (isInstanceNode() == false)
			return repeatSField;
		return (SFBool)getField(repeatSFieldName);
	}
	
	public void setRepeatS(boolean value) {
		getRepeatSField().setValue(value);
	}

	public void setRepeatS(String value) {
		getRepeatSField().setValue(value);
	}
	
	public boolean getRepeatS() {
		return getRepeatSField().getValue();
	}

	////////////////////////////////////////////////
	//	RepeatT
	////////////////////////////////////////////////

	public SFBool getRepeatTField() {
		if (isInstanceNode() == false)
			return repeatTField;
		return (SFBool)getField(repeatTFieldName);
	}
	
	public void setRepeatT(boolean value) {
		getRepeatTField().setValue(value);
	}

	public void setRepeatT(String value) {
		getRepeatTField().setValue(value);
	}
	
	public boolean getRepeatT() {
		return getRepeatTField().getValue();
	}


}

