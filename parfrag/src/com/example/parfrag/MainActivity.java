package com.example.parfrag;

import com.example.parfrag.fragments.HeadlinesFragment.IHeadlineSelectedListener;
import com.example.parfrag.fragments.NewsArticleFragment.IArticleSelectedListener;
import com.example.parfrag.fragments.NewsArticleFragment;
import com.example.parfrag.fragments.NewsDetailsFragment;
import com.example.parfrag.util.Constants;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements IHeadlineSelectedListener,IArticleSelectedListener {
	
	private static final String TAG="MainActivity";
	private static MainActivity mainActivityRunningInstance;
    public static MainActivity  getInstace(){
    	Log.i(TAG, Constants.log_info.Main_Activity_getInstace);
        return mainActivityRunningInstance;
    }
    
    public void updateUI(final String str) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
            	Log.i(TAG, Constants.log_info.Main_Activity_Run);
     //use findFragmentById for fragments defined in XML ((SimpleFragment)getSupportFragmentManager().findFragmentByTag(fragmentTag)).updateUI(str);
            	NewsArticleFragment nFragment = (NewsArticleFragment) getFragmentManager().findFragmentById(R.id.fragmentnewsarticle);
        		nFragment.updateNewsItemTv(str);
            }
        });
    }
    
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, Constants.log_info.Main_Activity_Oncreate);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainActivityRunningInstance =this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(TAG, Constants.log_info.Main_Activity_OncreateOptionsMenu);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG, Constants.log_info.Main_Activity_OnOptionsItemSelected);
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onHeadlineSelected(String textHeadline, int positionHeadline) {
		Log.i(TAG, Constants.log_info.Main_Activity_onHeadlineSelected);
		// TODO Auto-generated method stub
		NewsArticleFragment nFragment = (NewsArticleFragment) getFragmentManager().findFragmentById(R.id.fragmentnewsarticle);
		nFragment.updateNewsItemTv(textHeadline);

	}

	@Override
	public void onArticleSelected(String textHeadline) {
		Log.i(TAG, Constants.log_info.Main_Activity_onArticleSelected);
		// TODO Auto-generated method stub
		NewsDetailsFragment dFragment = (NewsDetailsFragment)getFragmentManager().findFragmentById(R.id.fragmentnewsdetails);
		dFragment.updateNewsDetailsTv(textHeadline);
	}
}
