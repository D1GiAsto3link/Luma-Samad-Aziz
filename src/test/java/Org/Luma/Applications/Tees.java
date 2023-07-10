package Org.Luma.Applications;

import Org.Luma.Reporters.ExtentHtmlReporter;

import Org.Luma.Tests.Testx1;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static Org.Luma.Reporters.ExtentHtmlReporter.getScreenshot;

public class Tees extends Testx1 {
    WebDriver driver = Testx1.driver;
    static Actions actions = new Actions(Testx1.driver);
    static WebDriverWait wait = new WebDriverWait(Testx1.driver, Duration.ofSeconds(8));
    public static void navigateToTopsTees() throws InterruptedException, IOException {
        ExtentHtmlReporter.test.info("User  hovers from men to tees to find an item ");
//        hover on men
        WebElement element =
                Testx1.driver.findElement(By.xpath("(//span[normalize-space()='Men'])[1]"));
        actions.moveToElement(element).perform();
        Thread.sleep(2500);
//        hover on tops
        WebElement tops = Testx1.driver.findElement(By.xpath("(//span[contains(text(),'Tops')])[2]"));
        actions.moveToElement(tops).build().perform();
        Thread.sleep(2500);
        ExtentHtmlReporter.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("tees")).build());
//       click tees
        Testx1.driver.findElement(By.xpath("//*[@id=\"ui-id-21\"]")).click();

    }

    public static void selectThreeStarsTee() throws IOException {
        ExtentHtmlReporter.test.info("user looks for a 3 starts item to add to cart");
        ExtentHtmlReporter.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("three StarTee")).build());
//       find 3 stars product item  to adds to cart
        Testx1.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]" +
                "/ol[1]/li[3]/div[1]/a[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void searchForItem(String productName) throws InterruptedException, IOException {
        ExtentHtmlReporter.test.info("User is searching for an item on the search field");
//        input on search box
        WebElement searchInput = Testx1.driver.findElement(By.id("search"));
        searchInput.sendKeys(productName);
        ExtentHtmlReporter.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Search for Item")).build());

//        click search button
        Testx1.driver.findElement(By.xpath("(//button[@title='Search'])[1]")).click();

        Thread.sleep(2000);
    }

    public static void scrollToMikoPullover(){
//       Find orange Miko Pullover Hoodie
        JavascriptExecutor js = (JavascriptExecutor)Testx1.driver;
        WebElement mikoPullover = Testx1.driver.findElement(By.xpath("(//img[@alt='Miko Pullover Hoodie'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", mikoPullover);
        mikoPullover.click();

    }
    public static void pullOverItem(){
   /*             Find orange Miko Pullover Hoodie
        BaseTests.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]" +
                "/ol/li[1]/div/a/span/span/img")).click();
        Size
    */
        WebElement  size = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-size-143-item-168'])[1]")));
        actions.moveToElement(size).click().perform();

//                    Color
        WebElement color= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-color-93-item-56'])[1]")));
        actions.moveToElement(color).click().perform();
    }

    public static void  heroHoodie(){
        ExtentHtmlReporter.test.info("User adds item to add ");
//        size
        WebElement hoodieSize = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-size-143-item-168'])[4]")));
        hoodieSize.click();
//        color
        WebElement hoodieColor = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-color-93-item-53'])[1]")));
        hoodieColor.click();


    }


}
