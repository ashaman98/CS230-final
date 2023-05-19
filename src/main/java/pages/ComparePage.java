package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locators.ComparePageConstants;

public class ComparePage extends BasePage{
    private By compareTable = By.id(ComparePageConstants.ITEM_CATALOG);


    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public void assertItemCount(int correctCount){
        wait(20).until((WebDriver d) -> {
            WebElement table = d.findElement(compareTable);
            int elementCount = table.findElements(By.xpath("./li")).size();
            System.out.println("CorrectCount " + correctCount + " " + elementCount);
            return elementCount == correctCount;
        });
    }

}
