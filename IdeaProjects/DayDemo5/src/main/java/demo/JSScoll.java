package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSScoll {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tiki.vn/");

        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement danhMuc = driver.findElement(By.xpath("//div[text()='Danh Mục Sản Phẩm']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",danhMuc);

        Thread.sleep(4000);
        driver.close();
    }
}
