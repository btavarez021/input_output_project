package org.example.Views;
import org.example.Exception.CLIException;
import org.example.Exception.MenuException;
import org.example.Model.MenuEntry;
import org.example.Service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class inputHandler {

    private MenuService menuService;

    public inputHandler(MenuService menuService) {
        this.menuService = menuService;
    }

    public String userMenuAction(String userInput) throws MenuException, CLIException {

        if (userInput.equals("4")){
            menuService.deleteAllMenuItem1(menuService);
            return "All menu items deleted!";
        }
        else if (userInput.equals("3")){
            menuService.deleteMenuItem();
            return "Food item deleted!";
        }
        else if (userInput.equals("1")) {
            addCliMenuItems();
        }
        else if (userInput.equals("2")) {
            HashMap<String, List<List<String>>> menuEntries = menuService.getMenuEntries();
            System.out.println(menuEntries);
            return "Menu Displayed!";
            }

//            else if (userInput.equals("3")) {
//                menuService.printAllEntries();
//            }
        else if (userInput.equals("5")) {
                System.exit(1);
                System.out.println("Successfully exited the menu entry application!");
            }
            return "Item Added!";
        }

    public void addCliMenuItems() throws MenuException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter food category: ");
        String itemTypeInput = sc.nextLine();
        System.out.println("Enter item name: ");
        String subTypeInput = sc.nextLine();
        System.out.println("Enter item price");
        double priceInput = sc.nextDouble();
        MenuEntry menuEntry = new MenuEntry(itemTypeInput, subTypeInput, priceInput);
        menuService.saveMenu(menuEntry);
    }

    public String returnAllCLIMenuItems(){
        HashMap<String, List<List<String>>> menuItems = menuService.printMenuEntries();
        return "Here are your menu items: " + menuItems;
    }

}
