package com.example.parfrag.fragments;


import com.example.parfrag.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NewsArticleFragment extends Fragment implements OnClickListener {
	TextView tvarticle;
	Button butheadline;
	public interface IArticleSelectedListener{
		public void onArticleSelected(String textHeadline);
	}

	IArticleSelectedListener mCallBack;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragement_news_article, null);
		tvarticle = (TextView)view.findViewById(R.id.textnewsarticle);
		butheadline = (Button)view.findViewById(R.id.buttonheadline);
		butheadline.setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mCallBack = (IArticleSelectedListener)activity;
	}
	
	public void updateNewsItemTv(String string)
	{
		tvarticle.setText(string);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String string = tvarticle.getText().toString();
		mCallBack.onArticleSelected(string);
		
	}


}
