package org.example.Service;

import org.example.Exception.CLIException;
import org.example.Exception.MenuException;

import java.util.*;

import org.example.Main;

public class MenuService {

    public HashMap<String, List<List<String>>> entries;

    public MenuService(){
        this.entries = new HashMap<>();

    }

    public void saveMenu(String itemType, String subItemType, double price) throws MenuException {

        Double price2 = new Double(price);

        if (price < 0){
            Main.log.info("Throwing exception due to formatting issue with the item price: " + price);
            throw new MenuException("Menu item cannot be negative");
        }
        else if (itemType.length() < 1){
            Main.log.info("Throwing exception due to formatting issue with the food type: " + itemType);
            throw new MenuException("Item type cannot be blank");
        }
        else if (subItemType.length() < 1){
            Main.log.info("Throwing exception due to formatting issue with the food item name: " + subItemType);
            throw new MenuException("Name of food item cannot be blank");
        }
        else if (price2 == null){
            Main.log.info("Throwing exception due to formatting issue due to the price: " + price);
            throw new MenuException("Item price cannot be blank");
        }
        else if (price2 < 0){
            Main.log.info("Throwing exception due to formatting issue due to the price: " + price);
            throw new MenuException("Item price cannot be negative");
        }
        else {
            List<List<String>> listOfLists = new ArrayList<>();
            List<String> itemList = new ArrayList<>();


            itemList.add(subItemType);
            itemList.add(String.valueOf(price));

            listOfLists.add(itemList);

            if (entries.containsKey(itemType)){
                List<List<String>> existingList = entries.get(itemType);
                existingList.addAll(new ArrayList<>(listOfLists));

                System.out.println(itemType);
                entries.put(itemType, existingList);
                System.out.println("Entries: " + entries);

            }
            else{
                entries.put(itemType, new ArrayList<>(Collections.singletonList(itemList)));
            }
        }
    }

    public HashMap<String, List<List<String>>> printMenuEntries(){
        System.out.println("Menu Entries: " + entries);
        return entries;
    }
//    public void printAllEntries() {
//        int i = 1;
//        System.out.println("These are all the Menu Items: ");
//        for (Map.Entry<String, List<String>> entry : entries.entrySet()){
//            String key = entry.getKey();
//            List<String> values = entry.getValue();
//            System.out.println("*****" + key + "*****");
//            for(String value : values){
//                System.out.println("   " + i++ + ". "+ value);
//            }
//        }
//    }

//    public void deleteAllMenuItem(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What food category to remove? ");
//        String removeFoodCategory = sc.nextLine();
//
//
//        String s1 = removeFoodCategory.substring(0,1).toUpperCase();
////        String capitalizedremoveFoodItem = s1 + removeFoodCategory.substring(1).toLowerCase();
//        entries.remove(removeFoodCategory);
//        System.out.println("Successfully removed: " + removeFoodCategory + " and all items items from the menu.");
//    }

    public void deleteAllMenuItem1() {
        System.out.println("Are you sure you want to delete all your menu items?");
        System.out.println("enter 'yes' to delete your menu.");
        Scanner sc = new Scanner(System.in);
        String confirmation = sc.nextLine();
        entries.clear();
        System.out.println("Entries deleted.");
    }

    public void deleteMenuItem() throws CLIException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What food category to remove? ");
        String removeFoodCategory = sc.nextLine();
        System.out.println("What food item to remove? ");
        String removeFoodItem = sc.nextLine();

        if(entries.containsKey(removeFoodCategory)){
            List<List<String>> listofLists = entries.get(removeFoodCategory);

            for(Iterator<List<String>> iterator=listofLists.iterator(); iterator.hasNext();){
                List<String> currentList = iterator.next();
                if (currentList.contains(removeFoodItem)){
                    iterator.remove();
                    System.out.println("Successfully removed: " + removeFoodItem + " from the menu.");
                    break;
                }
            }
        }
        else{
            throw new CLIException("Nothing to remove. Please make sure that item is still in the menu.");
        }

    }

    public Map<String, List<List<String>>> getEntries(){
        return this.entries;
    }
}
