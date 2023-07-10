package Org.Luma.Applications;

import Org.Luma.Tests.Testx1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class cart {
    WebDriver driver = Testx1.driver;

    public static void threeStarsAddToCart() throws IOException {
        Testx1.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();
    }
}
