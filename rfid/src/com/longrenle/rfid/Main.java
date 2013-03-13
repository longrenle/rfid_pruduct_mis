package com.longrenle.rfid;

import com.longrenle.rfid.fragment.RightFormFragment;
import com.longrenle.utils.LayoutUtils;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.os.Bundle;


public class Main extends FragmentActivity {
	
	final private String TAG = FragmentActivity.class.getCanonicalName();
	
	private LinearLayout mMainContent;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
        initViews();
        
        if(savedInstanceState == null) {
        	RightFormFragment fragment = new RightFormFragment();
//			fragment.setArguments(arguments);
			this.getSupportFragmentManager().beginTransaction()
					.add(R.id.main_right_detail, fragment).commit();
        }

    }
    
    /**
     * Initialize views and set position.
     */
    private void initViews() {
    	
    	mMainContent = (LinearLayout) findViewById(R.id.main_content);
    	
    	FrameLayout.LayoutParams lp = (LayoutParams) mMainContent.getLayoutParams();
    	lp.setMargins(0, LayoutUtils.getActionBarHeight(this), 0, 0);
    	mMainContent.setLayoutParams(lp);
    }
    

}
