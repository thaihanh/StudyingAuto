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
import java.util.Iterator;
import java.util.Set;

public class Exercise2 {
    @Test
    public void test() throws InterruptedException, AWTException, IOException {
        //----------------------------------------------------Java Script Alert Box-------------------------------------------------------------------
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to https://www.seleniumeasy.com/test/window-popup-modal-demo.html page.
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        driver.manage().window().maximize();
        String actualTitle1 = "Selenium Easy - Window Popup Modal Demo";
        String expectedTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1, expectedTitle1);
        System.out.println("Navigate to page successfully");
        //4. Click Follow On Twitter
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement followOnTwitterBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" +
                "//a[@href='https://twitter.com/intent/follow?screen_name=seleniumeasy']")));
        followOnTwitterBtn.click();

        for (String windows : driver.getWindowHandles()) {
            driver.switchTo().window(windows);
            System.out.println(driver.getTitle());
        }

        //5. Switch to window and get title page
        String parent1 = driver.getWindowHandle();
        Set<String> allWindowHandles1 = driver.getWindowHandles();
        Iterator<String> iterator1 = allWindowHandles1.iterator();
        while (iterator1.hasNext()) {
            String child = iterator1.next();
            if (!parent1.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                System.out.println("Title 1: " + driver.getTitle());
//                driver.close();
            }
        }
        //6. Back to window parent and click Like us On Facebook.
        driver.switchTo().window(parent1);
        WebElement likeUsOnFbBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://facebook.com/seleniumeasy']")));
        likeUsOnFbBtn.click();
        //7. Switch to window and get title page.
        String parent2 = driver.getWindowHandle();
        Set<String> allWindowHandles2 = driver.getWindowHandles();
        Iterator<String> iterator2 = allWindowHandles2.iterator();
        while (iterator2.hasNext()) {
            String child = iterator2.next();
            if (!parent2.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                System.out.println("Title 2: " + driver.getTitle());
//                driver.close();
            }
        }
        //8. Close browser
        driver.close();
    }
}
