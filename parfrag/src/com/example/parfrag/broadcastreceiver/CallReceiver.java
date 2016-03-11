package com.example.parfrag.broadcastreceiver;

import com.example.parfrag.util.Constants;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {

	private static final String TAG="CallReceiver";
	String phoneNumber;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, Constants.log_info.Call_Receive);
		//		Toast.makeText(context, "Phone state changed", Toast.LENGTH_LONG).show();
		//TelephonyManager tm = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE); 
		
		try{  
			String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);  

			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){  
				phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Toast.makeText(context, phoneNumber+" Phone Is Ringing", Toast.LENGTH_LONG).show();  
			}  

			if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){  
				Toast.makeText(context, " Call Recieved", Toast.LENGTH_LONG).show();  
			}  

			if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){  
				Toast.makeText(context, " Phone Is Idle", Toast.LENGTH_LONG).show();  
			}  
		}  
		catch(Exception e){e.printStackTrace();}  
	}

}
