package pages;

import locators.SmartphoneCategoryPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmartphoneCategoryPage extends BasePage {
    private By firstPhonePrice = By.xpath(SmartphoneCategoryPageConstants.FIRST_PHONE_PRICE);
    private By secondPhonePrice = By.xpath(SmartphoneCategoryPageConstants.SECOND_PHONE_PRICE);
    private By thirdPhonePrice = By.xpath(SmartphoneCategoryPageConstants.THIRD_PHONE_PRICE);
    private By compareButton = By.xpath(SmartphoneCategoryPageConstants.COMPARE_BUTTON);

    private By firstPhoneCompBtn = By.cssSelector(SmartphoneCategoryPageConstants.FIRST_PHONE_COMPARE);
    private By secondPhoneCompBtn = By.cssSelector(SmartphoneCategoryPageConstants.SECOND_PHONE_COMPARE);
    private By thirdPhoneCompBtn = By.cssSelector(SmartphoneCategoryPageConstants.THIRD_PHONE_COMPARE);

    public SmartphoneCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectPhonesToCompare() {
        WebElement firstPhoneBtn = wait(10)
                .until(ExpectedConditions.elementToBeClickable(firstPhoneCompBtn));
        firstPhoneBtn.click();

        WebElement secondPhoneBtn = wait(10)
                .until(ExpectedConditions.elementToBeClickable(secondPhoneCompBtn));
        secondPhoneBtn.click();

        WebElement thirdPhoneBtn = wait(10)
                .until(ExpectedConditions.elementToBeClickable(thirdPhoneCompBtn));
        thirdPhoneBtn.click();

    }

    public ComparePage goToCompare() {
        WebElement compare = wait(10)
                .until(ExpectedConditions.elementToBeClickable(compareButton));
        compare.click();
        return new ComparePage(driver);
    }

    public String[] getPrices() {
        String[] prices = new String[3];
        WebElement firstPhonePriceElement = wait(10).until(ExpectedConditions.elementToBeClickable(firstPhonePrice));
        prices[0] = firstPhonePriceElement.getText();

        WebElement secondPhonePriceElement = wait(10).until(ExpectedConditions.elementToBeClickable(secondPhonePrice));
        prices[1] = secondPhonePriceElement.getText();

        WebElement thirdPhonePriceElement = wait(10).until(ExpectedConditions.elementToBeClickable(thirdPhonePrice));
        prices[2] = thirdPhonePriceElement.getText();

        return prices;
    }
}