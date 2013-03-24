package com.longrenle.rfid.ui.control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface IFormControl {
	
	View getView(LayoutInflater inflater);
	
	void setLabel(String label);
	
	String getLabel();
	
	void setValue(String value);
	
	String getValue();
	
	void setLayoutParame(ViewGroup.LayoutParams layoutParams);
}
