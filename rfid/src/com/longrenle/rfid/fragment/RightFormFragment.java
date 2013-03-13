package com.longrenle.rfid.fragment;

import java.io.IOException;
import java.io.Reader;

import org.json.JSONArray;
import org.json.JSONStringer;

import com.longrenle.rfid.R;

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
    	
    	View view = inflater.inflate(R.layout.control_text, null);
    	((TextView)(view.findViewById(R.id.control_text_lbl))).setText("UserName:");
    	
    	RelativeLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
    														ViewGroup.LayoutParams.WRAP_CONTENT);
    	lp.alignWithParent = true;
    	lp.setMargins(50, 50, 0, 0);
    	view.setLayoutParams(lp);
    	
    	mRootLayout.addView(view);
    	
    	View view2 = inflater.inflate(R.layout.control_text, null);
    	((TextView)(view2.findViewById(R.id.control_text_lbl))).setText("Password:");
    	
    	RelativeLayout.LayoutParams lp2 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
    														ViewGroup.LayoutParams.WRAP_CONTENT);
    	lp2.alignWithParent = true;
    	lp2.setMargins(400, 50, 0, 0);
    	view2.setLayoutParams(lp2);
    	
    	mRootLayout.addView(view2);
    	
    	View view3 = inflater.inflate(R.layout.control_checkbox, null);
    	((TextView)(view3.findViewById(R.id.control_cbx_lbl))).setText("记住密码");
    	
    	
    	RelativeLayout.LayoutParams lp3 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
    														ViewGroup.LayoutParams.WRAP_CONTENT);
    	lp3.alignWithParent = true;
    	lp3.setMargins(50, 150, 0, 0);
    	view3.setLayoutParams(lp3);
    	
    	mRootLayout.addView(view3);
    	
    }
    
}
