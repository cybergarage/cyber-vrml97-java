/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Text.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import java.util.Date;
import cv97.*;
import cv97.field.*;

public class TextNode extends GeometryNode {
	
	//// ExposedField ////////////////
	private String	maxExtentExposedFieldName	= "maxExtent";
	private String	stringExposedFieldName		= "string";
	private String	lengthExposedFieldName		= "length";

	private SFFloat	maxExtentField;
	private MFFloat	lengthField;
	private MFString	stringField;

	public TextNode() {
		setHeaderFlag(false);
		setType(textTypeName);

		///////////////////////////
		// ExposedField 
		///////////////////////////

		// maxExtent exposed field
		maxExtentField = new SFFloat(1);
		addExposedField(maxExtentExposedFieldName, maxExtentField);

		// length exposed field
		lengthField = new MFFloat();
		addExposedField(lengthExposedFieldName, lengthField);

		// string exposed field
		stringField = new MFString();
		addExposedField(stringExposedFieldName, stringField);
	}

	public TextNode(TextNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	MaxExtent
	////////////////////////////////////////////////

	public SFFloat getMaxExtentField() {
		if (isInstanceNode() == false)
			return maxExtentField;
		return (SFFloat)getExposedField(maxExtentExposedFieldName);
	}
	
	public void setMaxExtent(float value) {
		getMaxExtentField().setValue(value);
	}

	public void setMaxExtent(String value) {
		getMaxExtentField().setValue(value);
	}
	
	public float getMaxExtent() {
		return getMaxExtentField().getValue();
	} 

	////////////////////////////////////////////////
	// String
	////////////////////////////////////////////////

	public MFString getStringField() {
		if (isInstanceNode() == false)
			return stringField;
		return (MFString)getExposedField(stringExposedFieldName);
	}

	public void addString(String value) {
		getStringField().addValue(value);
	}
	
	public int getNStrings() {
		return getStringField().getSize();
	}
	
	public void setString(int index, String value) {
		getStringField().set1Value(index, value);
	}

	public void setStrings(String value) {
		getStringField().setValues(value);
	}

	public void setStrings(String value[]) {
		getStringField().setValues(value);
	}
	
	public String getString(int index) {
		return getStringField().get1Value(index);
	}
	
	public void removeString(int index) {
		getStringField().removeValue(index);
	}

	////////////////////////////////////////////////
	// length
	////////////////////////////////////////////////

	public MFFloat getLengthField() {
		if (isInstanceNode() == false)
			return lengthField;
		return (MFFloat)getExposedField(lengthExposedFieldName);
	}

	public void addLength(float value) {
		getLengthField().addValue(value);
	}
	
	public int getNLengths() {
		return getLengthField().getSize();
	}
	
	public void setLength(int index, float value) {
		getLengthField().set1Value(index, value);
	}

	public void setLengths(String value) {
		getLengthField().setValues(value);
	}

	public void setLengths(String value[]) {
		getLengthField().setValues(value);
	}
	
	public float getLength(int index) {
		return getLengthField().get1Value(index);
	}
	
	public void removeLength(int index) {
		getLengthField().removeValue(index);
	}

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		if (node.isFontStyleNode())
			return true;
		else
			return false;
	}

	public void initialize() {
		super.initialize();
	}

	public void uninitialize() {
	}

	public void update() {
	}

	public void calculateBoundingBox() {
		// Not implemented
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		printStream.println(indentString + "\t" + "maxExtent " + getMaxExtent() );

		MFString string = getStringField();
		printStream.println(indentString + "\t" + "string [");
		string.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");

		MFFloat length = getLengthField();
		printStream.println(indentString + "\t" + "length [");
		length.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");

		FontStyleNode fontStyle = getFontStyleNodes();
		if (fontStyle != null) {
			if (fontStyle.isInstanceNode() == false) {
				String nodeName = fontStyle.getName();
				if (nodeName != null && 0 < nodeName.length())
					printStream.println(indentString + "\t" + "fontStyle DEF " + fontStyle.getName() + " FontStyle {");
				else
					printStream.println(indentString + "\t" + "fontStyle FontStyle {");
				fontStyle.outputContext(printStream, indentString + "\t");
				printStream.println(indentString + "\t" + "}");
			}
			else 
				printStream.println(indentString + "\t" + "fontStyle USE " + fontStyle.getName());
		}
	}
}
