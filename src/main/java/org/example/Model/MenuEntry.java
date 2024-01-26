package Model;

import java.util.HashMap;
import java.util.Map;

public class MenuEntry {

    private String itemType;
    private String subItemType;

    private double price;

    public MenuEntry(String itemType, String subItemType, double price){
        this.itemType = itemType;
        this.subItemType = subItemType;
        this.price = price;

    }

//    public void setLunchMenu(String lunchMenu){
//        this.lunchMenu = lunchMenu;
//    }
//
//    public String getLunchMenu(){
//        return this.lunchMenu;
//    }

    @Override
    public String toString() {
        return "**********Menu********** " + "\n" + this.itemType + this.subItemType + this.price;
    }
}
