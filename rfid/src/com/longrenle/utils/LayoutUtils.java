package com.longrenle.utils;

import android.content.Context;
import android.util.TypedValue;

public class LayoutUtils {
	
	/**
	 * Calculate ActionBar height.
	 * @return
	 */
	static public int getActionBarHeight(Context context){
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(
                    tv.data, context.getResources().getDisplayMetrics());
        }
		return 0;

	}

}
