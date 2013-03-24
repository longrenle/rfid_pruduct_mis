package com.longrenle.rfid.ui.control.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;

import com.longrenle.rfid.R;
import com.longrenle.rfid.ui.control.IFormControl;

public class FormTextControl implements IFormControl {

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
		if(mView != null) {
			((TextView)(mView.findViewById(R.id.control_text_lbl))).setText(lable + ":");
		}
	}

	@Override
	public String getLabel() {
		if(mView != null) {
			return ((TextView)(mView.findViewById(R.id.control_text_lbl))).getText().toString().replace(":", "");
		}
		return null;
	}

	@Override
	public void setValue(String value) {
		if(mView != null) {
			((EditText)(mView.findViewById(R.id.control_text_txt))).setText("Password:");
		}
	}

	@Override
	public String getValue() {
		if(mView != null) {
			return ((EditText)(mView.findViewById(R.id.control_text_txt))).getText().toString();
		}
		return null;
	}

	@Override
	public void setLayoutParame(LayoutParams layoutParams) {
		if(mView != null) {
			mView.setLayoutParams(layoutParams);
		}
	}

}
