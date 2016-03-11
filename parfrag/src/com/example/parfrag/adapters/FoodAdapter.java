package com.example.parfrag.adapters;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.example.parfrag.R;
import com.example.parfrag.food.FoodItem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdapter extends BaseAdapter {
	
	ArrayList<FoodItem> mFoodItems;
	Context mContext;
	int mResId;
	LayoutInflater inflater;
	
	public FoodAdapter(Context context, ArrayList<FoodItem> foodItems, int resId){
		mFoodItems = foodItems;
		mContext = context;
		mResId = resId;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFoodItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mFoodItems.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
       /* View view = inflater.inflate(mResId, null);
       
        TextView tvFoodTitle = (TextView)view.findViewById(R.id.textViewlarge);
        TextView tvSubtitle = (TextView)view.findViewById(R.id.textViewmedium);
        ImageView foodImageView = (ImageView)view.findViewById(R.id.imageView1);
        RatingBar foodBar = (RatingBar)view.findViewById(R.id.ratingBarrating);
       
        tvFoodTitle.setText(mFoodItems.get(position).getFoodName());
        tvSubtitle.setText(mFoodItems.get(position).getFoodDetails());
        foodImageView.setImageResource(mFoodItems.get(position).getFoodImage());
        foodBar.setRating(mFoodItems.get(position).getRating());
       
        return view;*/
		View vi = convertView;             //trying to reuse a recycled view
        ViewHolder holder = null;

        if (vi == null) {
                

                //The view is not a recycled one: we have to inflate
                vi = inflater.inflate(R.layout.list_row, parent, false);
                holder = new ViewHolder(vi);
                /*holder.tvFoodTitle = (TextView)vi.findViewById(R.id.textViewlarge);
                holder.tvSubtitle = (TextView)vi.findViewById(R.id.textViewmedium);
                holder.foodImageView = (ImageView)vi.findViewById(R.id.imageView1);
                holder.foodBar = (RatingBar)vi.findViewById(R.id.ratingBarrating);*/
                vi.setTag(holder);
        } else {
               

                // View recycled !
                // no need to inflate
                // no need to findViews by id
                holder = (ViewHolder) vi.getTag();
        }

        FoodItem foodItem = mFoodItems.get(position);

        holder.tvFoodTitle.setText(foodItem.getFoodName());
        holder.tvSubtitle.setText(foodItem.getFoodDetails());
        holder.foodImageView.setImageResource(foodItem.getFoodImage());
        holder.foodBar.setRating(foodItem.getRating());

        return vi;
	}
	static class ViewHolder{
        TextView tvFoodTitle;
        TextView tvSubtitle;
        ImageView foodImageView;
        RatingBar foodBar;
        public ViewHolder(View v) {
            tvFoodTitle = (TextView) v.findViewById(R.id.textViewlarge);
            tvSubtitle = (TextView) v.findViewById(R.id.textViewmedium);
            foodImageView = (ImageView)v.findViewById(R.id.imageView1);
            foodBar = (RatingBar)v.findViewById(R.id.ratingBarrating);
    }
}

}
