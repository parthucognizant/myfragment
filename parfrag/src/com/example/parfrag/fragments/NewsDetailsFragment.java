package com.example.parfrag.fragments;


import com.example.parfrag.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsDetailsFragment extends Fragment {
	
	TextView tvdetails;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_news_details, null);
		tvdetails = (TextView)view.findViewById(R.id.textdetails);
		return view;
	}
	public void updateNewsDetailsTv(String string)
	{
		tvdetails.setText(string);
	}

}
