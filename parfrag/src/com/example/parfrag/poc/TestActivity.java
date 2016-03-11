package com.example.parfrag.poc;

import com.example.parfrag.AppPreferences;
import com.example.parfrag.R;
import com.example.parfrag.database.DbContract.DbEntry;
import com.example.parfrag.database.DbOperations;
import com.example.parfrag.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity implements OnItemClickListener {
	private static final String TAG = "TestActivity";
	EditText et1,et2;
	CheckBox mCheckBox;
	RadioGroup rgGender;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		et1 = (EditText)findViewById(R.id.editText1);
		et2 = (EditText)findViewById(R.id.editText2);
		mCheckBox = (CheckBox)findViewById(R.id.checkBox1);
		rgGender = (RadioGroup)findViewById(R.id.radioGroup1);
		ListView lvdb = (ListView)findViewById(R.id.listViewDB);
		lvdb.setOnItemClickListener(this);
		populateListView();
	}

	@SuppressWarnings("deprecation")
	private void populateListView() {
		// TODO Auto-generated method stub
		ListView dbListview = (ListView)findViewById(R.id.listViewDB);
		DbOperations dbOperations = new DbOperations(this);
		dbOperations.openDb();
		Cursor datacursor = dbOperations.readRows();

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
				this,android.R.layout.simple_list_item_2, datacursor,
				new String[]{DbEntry.COLUMN_NAME_ENTRY_ID,DbEntry.COLUMN_NAME_TITLE},
				new int[]{android.R.id.text1,android.R.id.text2});
		dbListview.setAdapter(adapter);



	}

	public void handlePreference(View v)
	{
		Intent hIntent = new Intent(TestActivity.this,AppPreferences.class);
		startActivity(hIntent);
	}

	public void saveDb(View view)
	{
		Log.i(TAG, Constants.log_info.saveDb);
		DbOperations operations = new DbOperations(this);
		operations.openDb();
		switch (view.getId()) {
		case R.id.btnsavedb:
			operations.createRow(et1.getText().toString(), et2.getText().toString());
			break;
		case R.id.btnget:
			TextView tvread = (TextView)findViewById(R.id.textViewdb);
			tvread.setText(operations.readRow());
			break;
		case R.id.btndelete:
			operations.deleteRow();
			break;
		case R.id.btnupdate:
			operations.updateRow();
			break;

		default:
			break;
		}
		operations.closeDb();
	}
	public static int MODE = Activity.MODE_PRIVATE;
	public static String FILE_NAME = "mypreferences";
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		savePreferences();
	}

	private void savePreferences() {
		// TODO Auto-generated method stub
		SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE);
		SharedPreferences.Editor edit = preferences.edit();
		edit.putString(Constants.keys.ET1, et1.getText().toString());
		edit.putString(Constants.keys.ET2, et2.getText().toString());
		edit.putBoolean(Constants.keys.CB, mCheckBox.isChecked());
		RadioButton rb1 = (RadioButton)findViewById(rgGender.getCheckedRadioButtonId());
		edit.putBoolean(Constants.keys.RB, rb1.isChecked());
		edit.putInt(Constants.keys.RB_id, rgGender.getCheckedRadioButtonId());
		edit.commit();

	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//loadPreferences();
	}

	@SuppressWarnings("unused")
	private void loadPreferences() {
		//open file
		//read file
		SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE);
		et1.setText(preferences.getString(Constants.keys.ET1, ""));
		et2.setText(preferences.getString(Constants.keys.ET2, ""));
		mCheckBox.setChecked(preferences.getBoolean(Constants.keys.CB, false));
		RadioButton rb1 = (RadioButton)findViewById(preferences.getInt(Constants.keys.RB_id, rgGender.getCheckedRadioButtonId()));
		if(rb1!=null)
		{
			rb1.setChecked(preferences.getBoolean(Constants.keys.RB, true));
		}
	}

	@Override
	public void onItemClick(AdapterView<?> madapter, View arg1, int pos, long arg3) {
		// TODO Auto-generated method stub
		Cursor cursor = (Cursor)madapter.getItemAtPosition(pos);
		String name = cursor.getString(cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_ENTRY_ID));
		String name1 = cursor.getString(cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_TITLE));
		Toast.makeText(this, name+name1, Toast.LENGTH_LONG).show();
	}

}
