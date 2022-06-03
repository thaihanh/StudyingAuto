package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Day4 {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/majorleague/control/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("USERNAME"));
        username.sendKeys("123");
        Thread.sleep(3000);
        username.clear();

        username.sendKeys("admin");
        Thread.sleep(3000);

        System.out.println(username.getAttribute("placeholder"));
        System.out.println(username.getAttribute("type"));
        System.out.println(username.getAttribute("size"));

        System.out.println(username.getCssValue("display"));
        System.out.println(username.getCssValue("width"));
        System.out.println(username.getCssValue("font-size"));
        System.out.println(username.getCssValue("color"));

        username.submit();
        Thread.sleep(3000);

        List<WebElement> lsMessage = driver.findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        for (WebElement element:lsMessage){
            System.out.println(element.getText());
        }
        driver.close();
    }
}
