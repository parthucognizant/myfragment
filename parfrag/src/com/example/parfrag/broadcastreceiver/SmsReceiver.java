package com.example.parfrag.broadcastreceiver;

import com.example.parfrag.MainActivity;
import com.example.parfrag.SharingActivity;
import com.example.parfrag.fragments.HeadlinesFragment.IHeadlineSelectedListener;
import com.example.parfrag.util.Constants;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View.OnAttachStateChangeListener;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

	private static final String TAG="SmsReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {

		Log.i(TAG, Constants.log_info.Sms_Receive);
		// TODO Auto-generated method stub
		//		Toast.makeText(context, "Broadcast Done Successfully", Toast.LENGTH_SHORT).show();

		final Bundle bundle = intent.getExtras();

		try {

			if (bundle != null) {

				final Object[] pdusObj = (Object[]) bundle.get("pdus");

				for (int i = 0; i < pdusObj.length; i++) {

					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
					String phoneNumber = currentMessage.getDisplayOriginatingAddress();

					String senderNum = phoneNumber;
					String message = currentMessage.getDisplayMessageBody();

					//					Intent aIntent = new Intent(context,SharingActivity.class);
					//					aIntent.putExtra(Constants.keys.Phone_Number, phoneNumber);
					//					aIntent.putExtra(Constants.keys.Message, message);
					//					aIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					//					context.startActivity(aIntent);

					// Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);


					// Show alert
					//					int duration = Toast.LENGTH_LONG;
					//					Toast toast = Toast.makeText(context, "senderNum: "+ senderNum + ", message: " + message, duration);
					//					toast.show();

					//To display in fragment
					// the null check is for, if the activity is not running or in paused state, in my case the update was required onlyif the main activity is active or paused
					if(MainActivity.getInstace()!=null)
						MainActivity.getInstace().updateUI(message);

				} // end for loop
			} // bundle is null

		} catch (Exception e) {
			// Log.e("SmsReceiver", "Exception smsReceiver" +e);

		}

	}

}
