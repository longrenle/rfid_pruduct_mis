package com.longrenle.rfid.fragment;

import com.longrenle.rfid.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class LeftListFragment extends Fragment {

	final private String TAG = LeftListFragment.class.getCanonicalName();
	
	private Context mContext = getActivity();
	private ExpandableListView mMenuListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		mContext = getActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_left, container, false);
		initViews(rootView);
		loadMenuList();
		
		return rootView;
	}
	
    /**
     * Initialize views and set position.
     */
    private void initViews(View root) {
    	
    	mMenuListView = (ExpandableListView) root.findViewById(R.id.fragment_left_menu_list);
 
    	mMenuListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    	mMenuListView.setItemChecked(2, true);
    }
	

    /**
     * Load menu list from configuration.
     */
    private void loadMenuList() {
    	final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

    		private String[] generalsTypes = new String[] { "个人信息", "待办事项", "产品流程" };
    		
			private String[][] generals = new String[][] {
					{ "个人信息1", "个人信息2", "个人信息3"},
					{ "待办事项0", "待办事项1", "待办事项2" },
					{ "产品流程1", "产品流程1", "产品流程1", "产品流程1", "产品流程1" }

			};
			
			private int getItemId(int groupPosition, int childPosition) {
				int id = 0;
				for(int i=0; i<generalsTypes.length; i++) {
					id += generals[i].length;
				}
				id += childPosition;
				return id;
			}
			

			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return generalsTypes.length;
			}

			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return generalsTypes[groupPosition];
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return generals[groupPosition].length;
			}

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return generals[groupPosition][childPosition];
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return getItemId(groupPosition, childPosition);
			}

			@Override
			public boolean hasStableIds() {
				return true;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
			
				TextView textView = new TextView(mContext);
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 60);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL);
				textView.setPadding(36, 1, 1, 1);
				textView.setTextSize(20);
				textView.setTextColor(Color.BLACK);
				textView.setText(getGroup(groupPosition).toString());

				return textView;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView textView = new TextView(mContext);
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 50);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL);
				textView.setPadding(72, 1, 1, 1);
				textView.setTextSize(18);
				textView.setTextColor(Color.BLACK);
				textView.setText(getChild(groupPosition, childPosition).toString());

				return textView;
			}

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}

		};

		
		mMenuListView.setAdapter(adapter);
		
		
		//设置item点击的监听器
		mMenuListView.setOnChildClickListener(new OnChildClickListener() {
			Boolean clickedBoolean = false;
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
				
				mMenuListView.setSelectedChild(groupPosition, childPosition, true);
				
				
				Toast.makeText(
						mContext,
						"你点击了" + adapter.getChild(groupPosition, childPosition) + mMenuListView.getSelectedId(),
						Toast.LENGTH_SHORT).show();

				return false;
			}
		});
	}

}
