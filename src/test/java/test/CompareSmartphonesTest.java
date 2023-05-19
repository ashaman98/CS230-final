package test;

import org.testng.annotations.Test;

import org.testng.Assert;

import pages.ComparePage;
import pages.SmartphoneCategoryPage;

public class CompareSmartphonesTest extends BaseTest {
    @Test
    public void selectItemsAndCompare() {
        SmartphoneCategoryPage smartphonesPage = homePage.openSmartphoneCategory();
        smartphonesPage.selectPhonesToCompare();
        ComparePage comparePage = smartphonesPage.goToCompare();
        comparePage.assertItemCount(3);
    }

}
