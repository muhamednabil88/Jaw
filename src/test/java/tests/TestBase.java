package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver ;



    @BeforeSuite
    public void openBrowser() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.get("https://subscribe.stctv.com");
        //maximize window
        driver.manage().window().maximize();

        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));


    }

    @AfterSuite
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }


}
