/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : Shape.java
*
******************************************************************/

package cv97.node;

import java.io.PrintWriter;
import cv97.*;
import cv97.field.*;

public class ShapeNode extends Node {

	//// ExposedField ////////////////
	private String	appearanceExposedFieldName		= "appearance";
	private String	geometryExposedFieldName		= "geometry";

	SFNode appField;
	SFNode geomField;

	public ShapeNode() {
		setHeaderFlag(false);
		setType(shapeTypeName);

		///////////////////////////
		// ExposedField 
		///////////////////////////

		// appearance field
		appField = new SFNode();
		addExposedField(appearanceExposedFieldName, appField);

		// geometry field
		geomField = new SFNode();
		addExposedField(geometryExposedFieldName, geomField);
	}

	public ShapeNode(ShapeNode node) {
		this();
		setFieldValues(node);
	}

	////////////////////////////////////////////////
	//	Appearance
	////////////////////////////////////////////////

	public SFNode getAppearanceField() {
		if (isInstanceNode() == false)
			return appField;
		return (SFNode)getExposedField(appearanceExposedFieldName);
	}
	
	public void updateAppearanceField() {
		getAppearanceField().setValue(getAppearanceNodes());
	}

	////////////////////////////////////////////////
	//	Geometry
	////////////////////////////////////////////////

	public SFNode getGeometryField() {
		if (isInstanceNode() == false)
			return geomField;
		return (SFNode)getExposedField(geometryExposedFieldName);
	}
	
	public void updateGeometryField() {
		getGeometryField().setValue(getGeometryNode());
	}

	////////////////////////////////////////////////
	//	List
	////////////////////////////////////////////////

/* for Visual C++
	public Shape next() {
		return (Shape)next(getType());
	}

	public Shape nextTraversal() {
		return (Shape)nextTraversalByType(getType());
	}
*/

	////////////////////////////////////////////////
	//	abstract functions
	////////////////////////////////////////////////
	
	public boolean isChildNodeType(Node node){
		if (node.isAppearanceNode() || node.isGeometryNode())
			return true;
		else
			return false;
	}

	public void initialize() {
		super.initialize();
		updateAppearanceField();
		updateGeometryField();
	}

	public void uninitialize() {
	}

	public void update() {
		//updateAppearanceField();
		//updateGeometryField();
	}

	////////////////////////////////////////////////
	//	Infomation
	////////////////////////////////////////////////

	public void outputContext(PrintWriter printStream, String indentString) {

		AppearanceNode appearance = getAppearanceNodes();
		if (appearance != null) {
			if (appearance.isInstanceNode() == false) {
				String nodeName = appearance.getName();
				if (nodeName != null && 0 < nodeName.length())
					printStream.println(indentString + "\t" + "appearance DEF " + appearance.getName() + " Appearance {");
				else
					printStream.println(indentString + "\t" + "appearance Appearance {");
				appearance.outputContext(printStream, indentString + "\t");
				printStream.println(indentString + "\t" + "}");
			}
			else 
				printStream.println(indentString + "\t" + "appearance USE " + appearance.getName());
		}
		
		Node geonode = getGeometryNode();
		if (geonode != null) {
			if (geonode.isInstanceNode() == false) {
				String nodeName = geonode.getName();
				if (nodeName != null && 0 < nodeName.length())
					printStream.println(indentString + "\t" + "geometry DEF " + geonode.getName() + " " + geonode.getType() + " {");
				else
					printStream.println(indentString + "\t" + "geometry " + geonode.getType() + " {");
				geonode.outputContext(printStream, indentString + "\t");
				printStream.println(indentString + "\t" + "}");
			}
			else 
				printStream.println(indentString + "\t" + "geometry USE " + geonode.getName());
		}
	}
}