package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import locators.HomePageConstants;

public class HomePage extends BasePage {
    private By searchButton = By.xpath(HomePageConstants.SEARCH_BUTTON);
    private By searchbar = By.id(HomePageConstants.SEARCH_FIELD);
    private By loginButton = By.id(HomePageConstants.LOGIN_BUTTON);
    private By registerButton = By.xpath(HomePageConstants.REGISTER_BUTTON);
    private By categoriesButton = By.xpath(HomePageConstants.CATEGORIES_BUTTON);
    private By smartphoneCategoriesButton = By.xpath(HomePageConstants.SMARTPHONE_CATEGORIES_BUTTON);


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButtonElement.click();
    }

    public ShopPage searchForItem(String searchQuery) {
        WebElement searchbarElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(searchbar));
        searchbarElement.sendKeys(searchQuery);
        clickSearchButton();
        
        return new ShopPage(driver);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    public void clickRegisterButton() {
        WebElement registerButtonElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButtonElement.click();
    }

    public RegisterPage openRegisterPage() {
        clickLoginButton();
        clickRegisterButton();
        return new RegisterPage(driver);
    }

    public SmartphoneCategoryPage openSmartphoneCategory() {

        WebElement categoriesButtonElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(categoriesButton));

        Actions action = new Actions(driver);

        action.moveToElement(categoriesButtonElement).perform();

        WebElement smartphoneCategoriesButtonElement = wait(10)
            .until(ExpectedConditions.elementToBeClickable(smartphoneCategoriesButton));
        smartphoneCategoriesButtonElement.click();

        return new SmartphoneCategoryPage(driver);
    }
}
