/******************************************************************
*
*	CyberVRML97 for Java
*
*	Copyright (C) Satoshi Konno 1997-1998
*
*	File : IntValue.java
*
******************************************************************/

package cv97.field;

import java.io.Serializable;
import cv97.*;

public class IntValue extends Object implements Serializable {
	
	private int mValue; 

	public IntValue(int value) {
		setValue(value);
	}

	public void setValue(int value) {
		mValue = value;
	}
	
	public int getValue() {
		return mValue;
	}	
}
