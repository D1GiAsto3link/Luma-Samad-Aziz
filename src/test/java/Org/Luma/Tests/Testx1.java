package Org.Luma.Tests;

import Org.Luma.Applications.Tees;
import Org.Luma.Applications.Validations;
import Org.Luma.Applications.cart;
import Org.Luma.Reporters.ExtentHtmlReporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static Org.Luma.Reporters.ExtentHtmlReporter.createTest;

import static java.lang.Thread.*;

public class Testx1 {
   public static WebDriver driver;



    @BeforeSuite
   public static void beforeSuite(){
       ExtentHtmlReporter.initReports();

   }

   @AfterSuite
   public static void afterFlush() throws IOException {
       ExtentHtmlReporter.flushReports();
   }

/* @Parameters ("Browser")
@BeforeClass
    public void Setup(String browser) {
    driver = new ChromeDriver();
   *//* if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    } else if (browser.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    } else {
        throw new IllegalArgumentException("Invalid browser name: " + browser);
    }*//*
    driver.manage().window().maximize();
    driver.get("https://magento.softwaretestingboard.com ");
}

@Test
    public void testsetup() {

}*/

    @Test (priority = 1)   //this will open the browser up (basically connecting to the web)
    public void Setup(){
        WebDriverManager.chromedriver().setup();
       // driver.manage().window().maximize();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (priority = 2)   //this one will load the designated website to test
    public void openbrowser() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        sleep(2000);
    }

    @Test (priority = 3)
    public void Login() throws InterruptedException {
        driver.findElement(By.linkText("Sign In")).click();
        sleep(2500);

        driver.findElement(By.id("email")).sendKeys("J_3son1@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("n5!Krg@6RcbKFmY");
        sleep(2500);

        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
    }

    @Test (priority = 4)
    public static void tee()throws InterruptedException, IOException {
         ExtentHtmlReporter.test  = createTest("Three Stars Tee");
            Tees.navigateToTopsTees();
            Tees.selectThreeStarsTee();
        cart.threeStarsAddToCart();
        Validations.EmptyFields();
            sleep(2500);
    }

   /* @AfterMethod
    public  void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentHtmlReporter.test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentHtmlReporter.test.log(Status.PASS, result.getTestName());
            System.out.println("Test Passed");
        } else {
            ExtentHtmlReporter.test.log(Status.SKIP, result.getTestName());
        }
    }*/

}
