package com.longrenle.rfid.ui.control.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.longrenle.rfid.R;
import com.longrenle.rfid.ui.control.IFormControl;

public class FormRadioControl implements IFormControl {

	private View mView = null;

	@Override
	public View getView(LayoutInflater inflater) {
		
		if(mView == null) {
			mView = inflater.inflate(R.layout.control_text, null);
		}
		return mView;
	}
	
	@Override
	public void setLabel(String lable) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLayoutParame(LayoutParams layoutParams) {
		// TODO Auto-generated method stub

	}


}
