package Org.Luma.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testx1 {
   public static WebDriver driver;

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
    }

    @Test (priority = 2)   //this one will load the designated website to test
    public void openbrowser() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    public void Login() throws InterruptedException {
        driver.findElement(By.linkText("Sign In")).click();
        /*driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2500);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2500);

        driver.findElement(By.id("login-button")).click();
*/
    }
}
