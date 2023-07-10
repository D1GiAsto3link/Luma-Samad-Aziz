package Org.Luma.Applications;

import Org.Luma.Reporters.ExtentHtmlReporter;

import Org.Luma.Tests.Testx1;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Org.Luma.Reporters.ExtentHtmlReporter.getScreenshot;

public class Validations {
    WebDriver driver = Testx1.driver;
    static WebDriverWait wait = new WebDriverWait(Testx1.driver, Duration.ofSeconds(10));
    public static void EmptyFields() throws IOException {
//         Wait for the error message to be displayed
        ExtentHtmlReporter.test.info("User has not selected product size and color");
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='super_attribute[143]-error'])[1]")));

//         Verify the error message
        String expectedErrorMessage = "This is a required field.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        ExtentHtmlReporter.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Empty Field")).build());

    }
}
