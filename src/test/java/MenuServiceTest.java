import org.example.Exception.CLIException;
import org.example.Exception.MenuException;
import org.example.Main;
import org.example.Model.MenuEntry;
import org.example.Service.MenuService;
import org.example.Views.inputHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuServiceTest {

    MenuService menuService;

    @Before
    public void setUp(){menuService = new MenuService();}

    @Test
    public void menuServiceEmptyAtStart(){
        Map<String, List<List<String>>> menuList =menuService.entries;
        Assert.assertTrue(menuList.isEmpty());
    }
    @Test
    public void addMenu() throws MenuException {
        String foodCategory = "burger";
        String foodItemName = "bbq bacon burger";
        double price = 13.99;

        try {
            MenuEntry menuEntry = new MenuEntry(foodCategory, foodItemName, price);
            menuService.saveMenu(menuEntry);
        }catch (MenuException x){
            x.printStackTrace();
            Assert.fail("menu exception thrown");
        }

        Map<String, List<List<String>>> entries = menuService.printMenuEntries();

        Assert.assertTrue(entries.containsKey(foodCategory));

        Assert.assertEquals(1, entries.get(foodCategory).size());
        Assert.assertEquals(foodItemName, entries.get(foodCategory).get(0).get(0));
        Assert.assertEquals(price, Double.parseDouble(entries.get(foodCategory).get(0).get(1)),0.01);

    }
@Test
public void deleteAllMenuItems() throws MenuException, CLIException {
    String foodCategory = "burger";
    String foodItemName = "bbq bacon burger";
    double price = 13.99;

    MenuEntry menuEntry = new MenuEntry(foodCategory, foodItemName, price);
    menuService.saveMenu(menuEntry);

    Map<String, List<List<String>>> entriesBeforeDeletion = menuService.printMenuEntries();
    Assert.assertFalse(entriesBeforeDeletion.isEmpty());

    String simulatedInput = "yes";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    menuService.deleteAllMenuItem1(menuService);

    Map<String, List<List<String>>> entriesAfterDeletion = menuService.printMenuEntries();
    Assert.assertTrue(entriesAfterDeletion.isEmpty());
    }

}
