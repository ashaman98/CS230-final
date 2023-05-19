package test;

import org.testng.annotations.Test;
import pages.SmartphoneCategoryPage;
import org.testng.Assert;

public class SmartphoneCategoryPageTest extends BaseTest {
    @Test
    public void compareSmartphonePrices(){
        SmartphoneCategoryPage shopPage = homePage.openSmartphoneCategory();
        String[] prices = shopPage.getPrices();
        int min = 0;
        for (int i = 0; i < 3; i++) {
            String formattedPrice = prices[i].replace(".", "");
            int currentPrice = Integer.parseInt(formattedPrice);
            if (i == 0 || currentPrice < min) {
                min = currentPrice;
            }
        }
        Assert.assertTrue(min != 0);
    }
}