/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Material.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class MaterialNode extends Node {
	
	private String	transparencyFieldName			= "transparency";
	private String	ambientIntensityFieldName		= "ambientIntensity";
	private String	shininessFieldName				= "shininess";
	private String	diffuseColorFieldName			= "diffuseColor";
	private String	specularColorFieldName			= "specularColor";
	private String	emissiveColorFieldName			= "emissiveColor";

	private SFFloat transparencyField;
	private SFFloat ambientIntensityField;
	private SFFloat shininessField;
	private SFColor diffuseColorField;
	private SFColor specularColorField;
	private SFColor emissiveColorField;

	public MaterialNode() {
		setHeaderFlag(false);
		setType(materialTypeName);

		// tranparency exposed field
		transparencyField = new SFFloat(0.0f);
		transparencyField.setName(transparencyFieldName);
		addExposedField(transparencyField);

		// ambientIntesity exposed field
		ambientIntensityField = new SFFloat(0.2f);
		ambientIntensityField.setName(ambientIntensityFieldName);
		addExposedField(ambientIntensityField);

		// shininess exposed field
		shininessField = new SFFloat(0.2f);
		shininessField.setName(shininessFieldName);
		addExposedField(shininessField);

		// diffuseColor exposed field
		diffuseColorField = new SFColor(0.8f, 0.8f, 0.8f);
		diffuseColorField.setName(diffuseColorFieldName);
		addExposedField(diffuseColorField);

		// specularColor exposed field
		specularColorField = new SFColor(0.0f, 0.0f, 0.0f);
		specularColorField.setName(specularColorFieldName);
		addExposedField(specularColorField);

		// emissiveColor exposed field
		emissiveColorField = new SFColor(0.0f, 0.0f, 0.0f);
		emissiveColorField.setName(emissiveColorFieldName);
		addExposedField(emissiveColorField);
	}

	public MaterialNode(MaterialNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	Transparency
	////////////////////////////////////////////////

	public SFFloat getTransparencyField() {
		if (isInstanceNode() == false)
			return transparencyField;
		return (SFFloat)getExposedField(transparencyFieldName);
	}
	
	public void setTransparency(float value) {
		getTransparencyField().setValue(value);
	}

	public void setTransparency(String value) {
		getTransparencyField().setValue(value);
	}
	
	public float getTransparency() {
		return getTransparencyField().getValue();
	}

	////////////////////////////////////////////////
	//	AmbientIntensity
	////////////////////////////////////////////////

	public SFFloat getAmbientIntensityField() {
		if (isInstanceNode() == false)
			return ambientIntensityField;
		return (SFFloat)getExposedField(ambientIntensityFieldName);
	}
	
	public void setAmbientIntensity(float intensity) {
		getAmbientIntensityField().setValue(intensity);
	}

	public void setAmbientIntensity(String intensity) {
		getAmbientIntensityField().setValue(intensity);
	}
	
	public float getAmbientIntensity() {
		return getAmbientIntensityField().getValue();
	}

	////////////////////////////////////////////////
	//	Shininess
	////////////////////////////////////////////////

	public SFFloat getShininessField() {
		if (isInstanceNode() == false)
			return shininessField;
		return (SFFloat)getExposedField(shininessFieldName);
	}
	
	public void setShininess(float value) {
		getShininessField().setValue(value);
	}

	public void setShininess(String value) {
		getShininessField().setValue(value);
	}
	
	public float getShininess() {
		return getShininessField().getValue();
	}

	////////////////////////////////////////////////
	//	AmbientColor
	////////////////////////////////////////////////

	public void getAmbientColor(float value[]) {
		float ambientIntensity = getAmbientIntensity();
		getDiffuseColor(value);
		value[0] *= ambientIntensity;
		value[1] *= ambientIntensity;
		value[2] *= ambientIntensity;
	}

	////////////////////////////////////////////////
	//	DiffuseColor
	////////////////////////////////////////////////

	public SFColor getDiffuseColorField() {
		if (isInstanceNode() == false)
			return diffuseColorField;
		return (SFColor)getExposedField(diffuseColorFieldName);
	}

	public void setDiffuseColor(float value[]) {
		getDiffuseColorField().setValue(value);
	}
	
	public void setDiffuseColor(float r, float g, float b) {
		getDiffuseColorField().setValue(r, g, b);
	}

	public void setDiffuseColor(String value) {
		getDiffuseColorField().setValue(value);
	}
	
	public void getDiffuseColor(float value[]) {
		getDiffuseColorField().getValue(value);
	}

	////////////////////////////////////////////////
	//	SpecularColor
	////////////////////////////////////////////////

	public SFColor getSpecularColorField() {
		if (isInstanceNode() == false)
			return specularColorField;
		return (SFColor)getExposedField(specularColorFieldName);
	}

	public void setSpecularColor(float value[]) {
		getSpecularColorField().setValue(value);
	}
	
	public void setSpecularColor(float r, float g, float b) {
		getSpecularColorField().setValue(r, g, b);
	}

	public void setSpecularColor(String value) {
		getSpecularColorField().setValue(value);
	}
	
	public void getSpecularColor(float value[]) {
		getSpecularColorField().getValue(value);
	}

	////////////////////////////////////////////////
	//	EmissiveColor
	////////////////////////////////////////////////

	public SFColor getEmissiveColorField() {
		if (isInstanceNode() == false)
			return emissiveColorField;
		return (SFColor)getExposedField(emissiveColorFieldName);
	}

	public void setEmissiveColor(float value[]) {
		getEmissiveColorField().setValue(value);
	}
	
	public void setEmissiveColor(float r, float g, float b) {
		getEmissiveColorField().setValue(r, g, b);
	}
	
	public void setEmissiveColor(String value) {
		getEmissiveColorField().setValue(value);
	}
	
	public void getEmissiveColor(float value[]) {
		getEmissiveColorField().getValue(value);
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
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {
		float color[] = new float[3];
		getDiffuseColor(color);		printStream.println(indentString + "\t" + "diffuseColor " + color[X] + " "+ color[Y] + " " + color[Z] );
		printStream.println(indentString + "\t" + "ambientIntensity " + getAmbientIntensity() );
		getSpecularColor(color);	printStream.println(indentString + "\t" + "specularColor " + color[X] + " "+ color[Y] + " " + color[Z] );
		getEmissiveColor(color);	printStream.println(indentString + "\t" + "emissiveColor " + color[X] + " "+ color[Y] + " " + color[Z] );
		printStream.println(indentString + "\t" + "shininess " + getShininess() );
		printStream.println(indentString + "\t" + "transparency " + getTransparency() );
	}
}
