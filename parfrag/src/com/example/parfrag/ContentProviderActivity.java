package com.example.parfrag;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ContentProviderActivity extends ActionBarActivity {
	
	//Uri uri = android.provider.ContactsContract.Contacts.CONTENT_URI;
	Uri uri = Uri.parse("content://com.example.provider.Notes/tablename");
	ListView cplist;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_provider);
		cplist = (ListView)findViewById(R.id.listViewcontentprovider);
		fillList();
	}

	private void fillList() {
		// TODO Auto-generated method stub
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_list_item_2, cursor, 
				new String[]{"entryid","title"}, 
				new int[]{android.R.id.text1,android.R.id.text2});
		cplist.setAdapter(adapter);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		fillList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content, menu);
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
}
