import org.example.Exception.MenuException;
import org.example.Service.MenuService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class MenuServiceTest {

    MenuService menuService;

    @Before
    public void setUp(){menuService = new MenuService();}

    @Test
    public void menuServiceEmptyAtStart(){
        Map<String, List<List<String>>> menuList =menuService.entries;
        Assert.assertTrue(menuList.size() == 0);
    }
    @Test
    public void addMenu() throws MenuException {
        String foodCategory = "burger";
        String foodItemName = "bbq bacon burger";
        double price = 13.99;

        try {
            menuService.saveMenu(foodCategory, foodItemName, price);
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

//    public void assertMenuEntry(String itemType, String subItemType, String expectedPrice){
//        Map<String, List<List<String>>> entries = menuService.printMenuEntries();
//
//
//
//        Assert.assertTrue(entries.containsKey(itemType));
//
//        Assert.assertEquals(1, entries.get(itemType).size());
//        Assert.assertEquals(subItemType, entries.get(itemType).get(0).get(0));
//        Assert.assertEquals(expectedPrice, Double.parseDouble(entries.get(itemType).get(0).get(1)));
//    }


}
