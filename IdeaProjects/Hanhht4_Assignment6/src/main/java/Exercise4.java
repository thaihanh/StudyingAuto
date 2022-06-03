import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Exercise4 {
    @Test
    public void test() throws InterruptedException, AWTException, IOException {
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width webpage
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdevable.com/w3schools/tags/tryit5b70.html?filename=tryhtml_frame_cols");
        driver.manage().window().maximize();
        //4. Get and Check expected text as “This page is displayed in an iframe”
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iframeResult")));
        driver.switchTo().frame(iframe1);
        WebElement frameA = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@src='frame_a.html']")));
        driver.switchTo().frame(frameA);
        WebElement text = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        String expectTxt = "Note: The frameset, frame, and noframes elements are not supported in HTML5.";
        String actualTxt = text.getText();
        Assert.assertEquals(expectTxt, actualTxt);
        driver.close();
    }
}
