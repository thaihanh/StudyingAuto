package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSSendKeys {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");

        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('email').value=\"abc@gmail.com\"");
        WebElement email = (WebElement) javascriptExecutor.executeScript("return document.getElementById('email')");
        Thread.sleep(4000);
        email.clear();
        email.sendKeys("ddef@gmail.com");
        Thread.sleep(4000);
        driver.close();
    }
}
