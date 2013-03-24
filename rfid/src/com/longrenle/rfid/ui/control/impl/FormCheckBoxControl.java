package com.longrenle.rfid.ui.control.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;

import com.longrenle.rfid.R;
import com.longrenle.rfid.ui.control.IFormControl;

public class FormCheckBoxControl implements IFormControl {

	private View mView = null;

	@Override
	public View getView(LayoutInflater inflater) {
		
		if(mView == null) {
			mView = inflater.inflate(R.layout.control_checkbox, null);
			((TextView)(mView.findViewById(R.id.control_cbx_lbl))).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					CheckBox cbx = (CheckBox)(mView.findViewById(R.id.control_cbx_cbx));
					cbx.setChecked(!cbx.isChecked());
				}
				
			});
		}
		return mView;
	}

	@Override
	public void setLabel(String lable) {
		if(mView != null) {
			((TextView)(mView.findViewById(R.id.control_cbx_lbl))).setText(lable);
		}
	}

	@Override
	public String getLabel() {
		if(mView != null) {
			return ((TextView)(mView.findViewById(R.id.control_cbx_lbl))).getText().toString();
		}
		return null;
	}

	@Override
	public void setValue(String value) {
		if(mView != null) {
			((CheckBox)(mView.findViewById(R.id.control_cbx_cbx))).setChecked(value.equals("true"));
		}
	}

	@Override
	public String getValue() {
		if(mView != null) {
			return ((CheckBox)(mView.findViewById(R.id.control_cbx_cbx))).isChecked() ? "true" : "false";
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