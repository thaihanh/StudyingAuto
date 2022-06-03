package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EgDoubleClick {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(button).perform();
        Thread.sleep(4000);
        driver.close();
    }
}
