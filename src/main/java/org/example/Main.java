package org.example;

import org.example.Exception.CLIException;
import org.example.Exception.MenuException;
import java.util.Scanner;
import org.example.Views.inputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        showMenu();
    }

        public static void showMenu(){
        inputHandler inputHandler = new inputHandler();
        System.out.println(inputHandler);
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Welcome to the Menu Editor");
            System.out.println("1. Add menu entry");
            System.out.println("2. View menu entries");
//            System.out.println("3. View Formatted Menu");
            System.out.println("3. Delete a single menu item");
            System.out.println("4. Delete all items");
            System.out.println("5. Exit");
            String userInput = sc.nextLine();
            try {
                String output = inputHandler.userMenuAction(userInput);
                System.out.println(output);
            } catch (MenuException | CLIException e) {
                e.printStackTrace();
            }
        }

    }
}


