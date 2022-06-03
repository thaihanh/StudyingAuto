import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise3 {
    @Test
    public void test() throws InterruptedException, AWTException, IOException {
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width webpage
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.manage().window().maximize();
        //4. Get and Check expected text as “This page is displayed in an iframe”
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iframeResult")));
        driver.switchTo().frame(iframe1);
        WebElement iframe2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Iframe Example']")));
        driver.switchTo().frame(iframe2);
        WebElement text = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String expectTxt = "This page is displayed in an iframe";
        String actualTxt= text.getText();
        Assert.assertEquals(expectTxt, actualTxt);
        driver.close();
    }
}
