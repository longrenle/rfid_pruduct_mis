package com.longrenle.rfid.fragment;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONStringer;

import com.longrenle.rfid.R;
import com.longrenle.rfid.ui.control.IFormControl;
import com.longrenle.rfid.ui.control.impl.FormCheckBoxControl;
import com.longrenle.rfid.ui.control.impl.FormTextControl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class RightFormFragment extends Fragment {

	private Context mContext;
	final private String TAG = RightFormFragment.class.getCanonicalName();
	
	private RelativeLayout mRootLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		mContext = getActivity();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_right_form, container, false);
		initViews(rootView);
		
		return rootView;
	}
	
    /**
     * Initialize views and set position.
     */
    private void initViews(View root) {
    	
    	String aa = "{{id: 'front_camera_on',type: 'checkbox'},{id: 'redirect_uri',type: 'text'},{id: 'conference_factory_uri',type: 'text'}}";
    	
    	LayoutInflater inflater = LayoutInflater.from(mContext);
    	    	
    	mRootLayout = (RelativeLayout) root.findViewById(R.id.fragment_right_form_rootlayout);
 	
    	addControl(inflater, "text", "Username", 50, 50);
    	addControl(inflater, "text", "Password", 400, 50);
    	addControl(inflater, "checkbox", "Remember", 50, 150);
    	
    	
    }
    
    private void addControl(LayoutInflater inflater, String type, String label, int x, int y) {
    	
    	IFormControl control = null;
    	if(type.equals("text")) {
    		control = new FormTextControl();
    	} else if (type.equals("checkbox")) {
    		control = new FormCheckBoxControl();
    	}
    	
    	View view = control.getView(inflater);
    	mRootLayout.addView(view);
    	
    	RelativeLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
    														ViewGroup.LayoutParams.WRAP_CONTENT);
    	lp.alignWithParent = true;
    	lp.setMargins(x, y, 0, 0);
    	control.setLayoutParame(lp);
    	control.setLabel(label);
    	
    }
    
}
