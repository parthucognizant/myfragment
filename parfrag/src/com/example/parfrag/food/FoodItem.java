package com.example.parfrag.food;

public class FoodItem {
	
	String foodName;
	String foodDetails;
	int foodImage;
	float rating;
	public FoodItem(String foodName, String foodDetails, int foodImage,
			float rating) {
		super();
		this.foodName = foodName;
		this.foodDetails = foodDetails;
		this.foodImage = foodImage;
		this.rating = rating;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodDetails() {
		return foodDetails;
	}
	public void setFoodDetails(String foodDetails) {
		this.foodDetails = foodDetails;
	}
	public int getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(int foodImage) {
		this.foodImage = foodImage;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	

}
