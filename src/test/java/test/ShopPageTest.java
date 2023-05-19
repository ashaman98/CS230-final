package test;

import org.testng.annotations.Test;
import pages.ShopPage;

public class ShopPageTest extends BaseTest {
    @Test
    public void addToCartAndCheckItemCountTest(){
        ShopPage shopPage = homePage.searchForItem("Samsung");
        shopPage.addToCart();
        shopPage.assertItemInCartExists();
    }
    @Test
    public void checkCountsPerPage() {
        ShopPage shopPage = homePage.searchForItem("Samsung");
        int selectedCountPerPage = shopPage.changeCountPerPage();
        shopPage.assertItemCount(selectedCountPerPage);
    }
}
