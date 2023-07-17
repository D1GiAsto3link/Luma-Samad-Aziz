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
import org.testng.Assert;
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

    @Test  //this will open the browser up (basically connecting to the web)
    public void part1() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
        sleep(2000);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        driver.findElement(By.linkText("Sign In")).click();
        sleep(2500);
        driver.findElement(By.id("email")).sendKeys("J_3son1@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("n5!Krg@6RcbKFmY");
        sleep(2500);
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ExtentHtmlReporter.test  = createTest("Three Stars Tee");
        Tees.navigateToTopsTees();
        Tees.selectThreeStarsTee();
        cart.threeStarsAddToCart();
        Validations.EmptyFields();
        sleep(2500);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    /*@AfterMethod
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
