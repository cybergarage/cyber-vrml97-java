/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Anchor.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class AnchorNode extends GroupingNode {

	//// ExposedField ////////////////
	private String	descriptionExposedFieldName		= "description";
	private String	parameterExposedFieldName			= "parameter";
	private String	urlExposedFieldName					= "url";

	private SFString descriptionField;
	private MFString parameterField;
	private MFString urlField;
	
	public AnchorNode() {
		super();

		setHeaderFlag(false);
		setType(anchorTypeName);

		///////////////////////////
		// Exposed Field 
		///////////////////////////

		// description exposed field
		descriptionField = new SFString();
		addExposedField(descriptionExposedFieldName, descriptionField);

		// parameter exposed field
		parameterField = new MFString();
		addExposedField(parameterExposedFieldName, parameterField);

		// url exposed field
		urlField = new MFString();
		addExposedField(urlExposedFieldName, urlField);
	}

	public AnchorNode(AnchorNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	Description
	////////////////////////////////////////////////

	public SFString getDescriptionField() {
		if (isInstanceNode() == false)
			return descriptionField;
		return (SFString)getExposedField(descriptionExposedFieldName);
	}

	public void setDescription(String value) {
		getDescriptionField().setValue(value);
	}

	public String getDescription() {
		return getDescriptionField().getValue();
	}

	////////////////////////////////////////////////
	// Parameter
	////////////////////////////////////////////////

	public MFString getParameterField() {
		if (isInstanceNode() == false)
			return parameterField;
		return (MFString)getExposedField(parameterExposedFieldName);
	}

	public void addParameter(String value) {
		getParameterField().addValue(value);
	}
	
	public int getNParameters() {
		return getParameterField().getSize();
	}
	
	public void setParameter(int index, String value) {
		getParameterField().set1Value(index, value);
	}
	
	public void setParameters(String value) {
		getParameterField().setValues(value);
	}
	
	public void setParameters(String value[]) {
		getParameterField().setValues(value);
	}
	
	public String getParameter(int index) {
		return getParameterField().get1Value(index);
	}
	
	public void removeParameter(int index) {
		getParameterField().removeValue(index);
	}

	////////////////////////////////////////////////
	// URL
	////////////////////////////////////////////////

	public MFString getURLField() {
		if (isInstanceNode() == false)
			return urlField;
		return (MFString)getExposedField(urlExposedFieldName);
	}

	public void addURL(String value) {
		getURLField().addValue(value);
	}
	
	public int getNURLs() {
		return getURLField().getSize();
	}
	
	public void setURL(int index, String value) {
		getURLField().set1Value(index, value);
	}
	
	public void setURLs(String value) {
		getURLField().setValues(value);
	}
	
	public void setURLs(String value[]) {
		getURLField().setValues(value);
	}
	
	public String getURL(int index) {
		return getURLField().get1Value(index);
	}
	public void removeURL(int index) {
		getURLField().removeValue(index);
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

		SFString description = getDescriptionField();
		printStream.println(indentString + "\t" + "description " + description);
		
		MFString parameter = getParameterField();
		printStream.println(indentString + "\t" + "parameter [");
		parameter.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");

		MFString url = getURLField();
		printStream.println(indentString + "\t" + "url [");
		url.outputContext(printStream, indentString + "\t\t");
		printStream.println(indentString + "\t" + "]");
	}
}
