package com.example.parfrag.fragments;

import com.example.parfrag.R;
import com.example.parfrag.util.Constants;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class HeadlinesFragment extends Fragment implements OnItemClickListener {
	
	private static final String TAG="HeadlinesFragment";
	
	public interface IHeadlineSelectedListener{
		public void onHeadlineSelected(String textHeadline, int positionHeadline);
	}

	IHeadlineSelectedListener mCallBack;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, Constants.log_info.Headline_Fragment_OnCreateView);
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_headlines, null);
		ListView headlinesListview = (ListView)view.findViewById(R.id.listviewHeadlines);
		headlinesListview.setOnItemClickListener(this);
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mCallBack = (IHeadlineSelectedListener)activity;
	}


	@Override
	public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
//		Toast.makeText(getActivity(), "pos "+pos, Toast.LENGTH_SHORT).show();
		
		mCallBack.onHeadlineSelected(adapter.getItemAtPosition(position).toString(), position);
		
	}

}
