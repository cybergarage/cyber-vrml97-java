/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : DoubleValue.java
*
******************************************************************/

package cv97.field;

import java.io.Serializable;
import cv97.*;

public class DoubleValue extends Object implements Serializable {
	
	private double mValue; 

	public DoubleValue(double value) {
		setValue(value);
	}
	
	public void setValue(double value) {
		mValue = value;
	}
	
	public double getValue() {
		return mValue;
	}	
}
