package com.example.parfrag;

import com.example.parfrag.util.Constants;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SharingActivity extends ActionBarActivity implements OnInitListener {
	
	String message="";
	private TextToSpeech mTts;
	private static final String TAG="SharingActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, Constants.log_info.Sharing_Activity_onCreate);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sharing);
		mTts=new TextToSpeech(this, this);
		if(getIntent().getExtras().getString(Constants.keys.Message) != null)
		{
			message=getIntent().getExtras().getString(Constants.keys.Message);
			Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(TAG, Constants.log_info.Sharing_Activity_onCreateOptionsMenu);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sharing, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG, Constants.log_info.Sharing_Activity_onOptionsItemSelected);
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
	public void onInit(int arg0) {
		Log.i(TAG, Constants.log_info.Sharing_Activity_onInit);
		// TODO Auto-generated method stub
		mTts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
	}
}
