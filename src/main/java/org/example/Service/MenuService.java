package org.example.Service;

import org.example.Model.MenuEntry;
import org.example.Exception.CLIException;
import org.example.Exception.MenuException;

import java.util.*;

import org.example.Main;

public class MenuService {

    public HashMap<String, List<List<String>>> entries;

    public MenuService(){

        this.entries = new HashMap<>();
    }

    public void saveMenu(MenuEntry menuEntry) throws MenuException {

        if (menuEntry.getFoodCategory().isEmpty()){
            Main.log.warn("Throwing exception due to formatting issue with the food type: " + menuEntry.getFoodCategory());
            throw new MenuException("Item type cannot be blank");
        }
        else if (menuEntry.getFoodItem().isEmpty()){
            Main.log.warn("Throwing exception due to formatting issue with the food item name: " + menuEntry.getFoodItem());
            throw new MenuException("Name of food item cannot be blank");
        }
        else if (menuEntry.getPrice() < 0){
            Main.log.warn("Throwing exception due to formatting issue due to the price: " + menuEntry.getPrice());
            throw new MenuException("Item price cannot be negative");
        }
        else {
            List<List<String>> listOfLists = new ArrayList<>();
            List<String> itemList = new ArrayList<>();


            itemList.add(menuEntry.getFoodItem());
            itemList.add(String.valueOf(menuEntry.getPrice()));

            listOfLists.add(itemList);

            if (entries.containsKey(menuEntry.getFoodCategory())){
                List<List<String>> existingList = entries.get(menuEntry.getFoodCategory());
                existingList.addAll(new ArrayList<>(listOfLists));

                System.out.println(menuEntry.getFoodCategory());
                entries.put(menuEntry.getFoodCategory(), existingList);
//                System.out.println("Entries: " + entries);

            }
            else{
                entries.put(menuEntry.getFoodCategory(), new ArrayList<>(Collections.singletonList(itemList)));
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

    public void deleteAllMenuItem1(MenuService menuService) {
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("Are you sure you want to delete all your menu items?");
            System.out.println("enter 'yes' to delete your menu.");
            Scanner sc = new Scanner(System.in);
            String confirmation = sc.nextLine().trim().toLowerCase();
            if (confirmation.equals("yes")) {
                entries.clear();
                System.out.println("Entries deleted.");
                Main.log.info("All entries deleted.");
                continueLoop = false;
            } else {
                System.out.println("No entries deleted. Returning back to the menu.");
                Main.log.info("No entries deleted. Returning back to the menu.");
                Main.showMenu(menuService);
            }
        }
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
                    Main.log.info("Successfully removed: " + removeFoodItem + " from the menu.");
                    break;
                }
            }
        }
        else{
            Main.log.info("You tried to remove the following... ");
            Main.log.info("Food Category: " + removeFoodCategory);
            Main.log.info("Food Item: " + removeFoodItem);
            Main.log.warn("Nothing to remove. Please make sure that items above are still in the menu.");
            throw new CLIException("Nothing to remove. Please make sure that item is still in the menu.");
        }

    }

    public void searchMenuItem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the search");
        System.out.println("Please enter a food category: ");
        String foodCategory = sc.nextLine();

        if (entries.containsKey(foodCategory)) {
            System.out.println("Here is the food category and its items that you requested: " + entries.get(foodCategory));
        }
    }

    public Map<String, List<List<String>>> getEntries(){
        return this.entries;
    }

    public HashMap<String, List<List<String>>> getMenuEntries() {
        return new HashMap<>(entries);
    }
}
