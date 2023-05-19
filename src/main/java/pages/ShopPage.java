package pages;

import locators.ShopPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopPage extends BasePage {

    private By addToCartButton = By.xpath(ShopPageConstants.BUY_BUTTON);
    private By resultsTable = By.id(ShopPageConstants.ITEM_CATALOG);
    private By resultsTableItem = By.cssSelector(ShopPageConstants.ITEM);
    private By cartRow = By.cssSelector(ShopPageConstants.CART_ROW);
    private By countPerPageDropDown = By.xpath(ShopPageConstants.COUNT_PER_PAGE_DROPDOWN);
    private By countPerPageOption = By.xpath(ShopPageConstants.COUNT_PER_PAGE_OPTION);

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void assertResultsExist() {
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
    }

    public void addToCart() {
        WebElement addToCartButtonElement = wait(10).until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButtonElement.click();
    }

    public void assertItemInCartExists() {
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(cartRow));
    }

    public void clickCountPerPage() {
        WebElement countPerPage = wait(10).until(ExpectedConditions.elementToBeClickable(countPerPageDropDown));
        countPerPage.click();
    }

    public int changeCountPerPage() {
        clickCountPerPage();
        WebElement countPerPageOptionElement = wait(10)
                .until(ExpectedConditions.elementToBeClickable(countPerPageOption));
        int value = Integer.parseInt(countPerPageOptionElement.getText());
        countPerPageOptionElement.click();

        return value;
    }

    public void assertItemCount(int correctCount) {
        wait(20).until((WebDriver d) -> {
            WebElement table = d.findElement(resultsTable);
            int elementCount = table.findElements(By.xpath("./li")).size();
            System.out.println("CorrectCount " + correctCount + " " + elementCount);
            
            return elementCount == correctCount;
        });
    }

}
