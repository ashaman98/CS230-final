package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriverWait wait(int seconds) {
    return new WebDriverWait(driver, Duration.ofSeconds(seconds));
  }
}
