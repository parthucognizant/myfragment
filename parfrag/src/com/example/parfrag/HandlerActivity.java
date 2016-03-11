package com.example.parfrag;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class HandlerActivity extends ActionBarActivity {

	 ProgressBar mBar;
     Handler pbHandler = new Handler(){
                    
             public void handleMessage(android.os.Message msg) {
                     mBar.incrementProgressBy(5);
             };
     };


     @Override
     protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_handler);
             mBar = (ProgressBar)findViewById(R.id.progressBar1);
     }

     @Override
     protected void onStart() {
             // TODO Auto-generated method stub
             super.onStart();
             //create a bg thread to download data
             BackgroundThread bgThread = new BackgroundThread();
             bgThread.start();
             // as it downloads data update progress
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
             // Inflate the menu; this adds items to the action bar if it is present.
             getMenuInflater().inflate(R.menu.handler, menu);
             return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
             // Handle action bar item clicks here. The action bar will
             // automatically handle clicks on the Home/Up button, so long
             // as you specify a parent activity in AndroidManifest.xml.
             int id = item.getItemId();
             if (id == R.id.action_settings) {
                     return true;
             }
             return super.onOptionsItemSelected(item);
     }

     public class BackgroundThread extends Thread{
             @Override
             public void run() {
                     super.run();
                     for (int i=0; i<20; i++){
                             try {
                                     Thread.sleep(1000);
                                     //mBar.incrementProgressBy(5);

                                     pbHandler.sendMessage(pbHandler.obtainMessage());       
                             } catch (InterruptedException e) {
                                     // TODO Auto-generated catch block
                                     e.printStackTrace();
                             }
                     }

             }
     }
}
