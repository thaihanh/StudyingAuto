package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenu {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));

        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));

        actions.contextClick(rightClick).moveToElement(edit).click().build().perform();

        Thread.sleep(4000);
        driver.close();
    }
}
