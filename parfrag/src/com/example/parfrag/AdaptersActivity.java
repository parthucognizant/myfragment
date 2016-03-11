package com.example.parfrag;

import java.util.ArrayList;

import com.example.parfrag.adapters.FoodAdapter;
import com.example.parfrag.food.FoodItem;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class AdaptersActivity extends ActionBarActivity {
	
	ArrayList<FoodItem> foodItems = new ArrayList<>();
	
	private void generateData(){
		foodItems.add(new FoodItem("Siggu", "Vekam",
				R.drawable.ic_launcher, 5));
		foodItems.add(new FoodItem("Tinnava", "Saptiya",
				R.drawable.ic_launcher, 4));
		foodItems.add(new FoodItem("Twaraga", "Sigrame",
				R.drawable.ic_launcher, 3));
		foodItems.add(new FoodItem("Ekadiki Raa", "Inga Vaa",
				R.drawable.ic_launcher, 2));
		foodItems.add(new FoodItem("Burra Leda", "AruvIliya",
				R.drawable.ic_launcher, 5));
		foodItems.add(new FoodItem("Nidra Vastundi", "Thukam Varudhu",
				R.drawable.ic_launcher, 4));
		foodItems.add(new FoodItem("Avataliki Po", "Poi Tholla",
				R.drawable.ic_launcher, 1));
		foodItems.add(new FoodItem("Navvu", "Siruppu",
				R.drawable.ic_launcher, 5));
		foodItems.add(new FoodItem("Bhayapadodhu", "Kavalapadhu",
				R.drawable.ic_launcher, 4));
		foodItems.add(new FoodItem("Chai(Hand)", "Kai",
				R.drawable.ic_launcher, 3));
		foodItems.add(new FoodItem("Andam", "Alaga",
				R.drawable.ic_launcher, 2));
		foodItems.add(new FoodItem("Teledha", "Tereyadha",
				R.drawable.ic_launcher, 5));
		foodItems.add(new FoodItem("Mati Matiki", "Adiki Adike",
				R.drawable.ic_launcher, 4));
		foodItems.add(new FoodItem("Ardamayenda", "Purinjudha",
				R.drawable.ic_launcher, 1));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapters);
		 ListView foodListView = (ListView)findViewById(R.id.listViewadapters);
         generateData();
         FoodAdapter adapter = new FoodAdapter(this, foodItems, R.layout.list_row);
         foodListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adapters, menu);
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
