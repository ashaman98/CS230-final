package test;

import org.testng.annotations.Test;
import pages.ShopPage;

public class HomePageTest extends BaseTest {
    @Test
    public void correctSearchTest() {
        ShopPage shopPage = homePage.searchForItem("Samsung");
        shopPage.assertResultsExist();
        
    }

    @Test
    public void partialSearchTest() {
       
        ShopPage shopPage = homePage.searchForItem("Sams");
        shopPage.assertResultsExist();
    }
    //The two tests below are failing because the redstore search isnt smart enough
    @Test
    public void typoSearchTest() {
        
        ShopPage shopPage = homePage.searchForItem("Smsug");
        shopPage.assertResultsExist();
    }

    @Test
    public void armSearchTest() {
        
        ShopPage shopPage = homePage.searchForItem("Սմարթֆոններ");
        shopPage.assertResultsExist();
    }
}
