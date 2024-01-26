package org.example.Model;

import java.util.HashMap;
import java.util.Map;

public class MenuEntry {

    private String foodCategory;
    private String foodItem;

    private double price;

    public MenuEntry(String foodCategory, String foodItem, double price){
        this.foodCategory = foodCategory;
        this.foodItem = foodItem;
        this.price = price;

    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "**********Menu********** " + "\n" + this.foodCategory + this.foodItem + this.price;
    }
}
