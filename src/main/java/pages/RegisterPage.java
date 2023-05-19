package pages;

import locators.RegisterPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
  
  private By nameField = By.cssSelector(RegisterPageConstants.NAME_FIELD);
  private By emailField = By.cssSelector(RegisterPageConstants.EMAIL_FIELD);
  private By passwordField = By.cssSelector(RegisterPageConstants.PASSWORD_FIELD);
  private By confirmPasswordField = By.cssSelector(RegisterPageConstants.CONFIRM_PASSWORD_FIELD);
  private By registerButton = By.cssSelector(RegisterPageConstants.REGISTER_BUTTON);
  
  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public void fillNameField(String name) {
    WebElement nameFieldElement = wait(10).until(ExpectedConditions.elementToBeClickable(nameField));
    nameFieldElement.sendKeys(name);
  }

  public void fillEmailField(String email) {
    WebElement emailFieldElement = wait(10).until(ExpectedConditions.elementToBeClickable(emailField));
    emailFieldElement.sendKeys(email);
  }

  public void fillPasswordField(String password) {
    WebElement passwordFieldElement = wait(10).until(ExpectedConditions.elementToBeClickable(passwordField));
    passwordFieldElement.sendKeys(password);
  }

  public void fillConfirmPasswordField(String password) {
    WebElement confirmPasswordFieldElement = wait(10).until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
    confirmPasswordFieldElement.sendKeys(password);
  }

  public void clickRegisterButton() {
    WebElement registerButtonElement = wait(10).until(ExpectedConditions.elementToBeClickable(registerButton));
    registerButtonElement.click();
  }
}
