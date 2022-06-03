package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Day4d {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement table = driver.findElement(By.id("task-table"));
        List<WebElement> lsTR = table.findElements(By.tagName("tr"));
        for (WebElement element : lsTR) {
            List<WebElement> lsTD = element.findElements(By.tagName("td"));
            for (WebElement td : lsTD) {
                System.out.println(td.getText());
            }
        }
        driver.close();
    }
}
