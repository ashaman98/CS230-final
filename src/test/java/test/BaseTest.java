package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import pages.HomePage;

public class BaseTest {
    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "/usr/bin/chromedriver";
    public static final String URL = "https://redstore.am/";
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup() {
        System.setProperty(WEBDRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void before() {
        driver.get(URL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Finished testing");
    }
    
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
           takeScreenshot(result.getName());
        }
    }

    private void takeScreenshot(String testName) {
       
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        String screenshotPath = screenshotDir + testName + ".png";

        try {
        
            File screenshotDirFile = new File(screenshotDir);
            screenshotDirFile.mkdirs();

            Files.copy(screenshot, new File(screenshotPath));
            System.out.println("Screenshot in: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
