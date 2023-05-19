package test;

import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterPageTest extends BaseTest {
  @Test
  public void registerTest() {
    RegisterPage registerPage = homePage.openRegisterPage();
    registerPage.fillNameField("test");
    registerPage.fillEmailField("test@gmail.com");
    registerPage.fillPasswordField("test1234");
    registerPage.fillConfirmPasswordField("test1234");

    // Commented not to register a new user, 
    // but there is no field validation to write meaningful tests
    
    // registerPage.clickRegisterButton();
  }
}
