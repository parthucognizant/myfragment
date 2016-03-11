package com.example.parfrag.loader;

import com.example.parfrag.R;
import com.example.parfrag.R.id;
import com.example.parfrag.R.layout;
import com.example.parfrag.R.menu;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class LoaderActivity extends ActionBarActivity implements LoaderCallbacks<Cursor> {
	
	private static final int LOADER_ID = 0;
	SimpleCursorAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
		ListView loaderListView = (ListView)findViewById(R.id.listViewLoader);
		mAdapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_expandable_list_item_2, 
				null, new String[]{"body","address"}, new int[]{android.R.id.text1,android.R.id.text2},0);
		loaderListView.setAdapter(mAdapter);
		getLoaderManager().initLoader(LOADER_ID, null, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loader, menu);
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

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		if(id == LOADER_ID){
		return new CursorLoader(this, Uri.parse("content://sms/inbox"), new String[]{"_id", "body","address"}, "address='7702285002'", null, null);
		}
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
		// TODO Auto-generated method stub
		mAdapter.swapCursor(cursor);
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
}
