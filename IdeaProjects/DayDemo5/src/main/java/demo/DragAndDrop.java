package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement fourth = driver.findElement(By.id("fourth"));

        WebElement li = driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[2]"));
        Thread.sleep(2000);
        actions.dragAndDrop(fourth,li).perform();

        Thread.sleep(4000);
        driver.close();
    }
}
