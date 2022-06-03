package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Day4b {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        WebElement select = driver.findElement(By.id("select-demo"));
        Select s = new Select(select);
        s.selectByIndex(4);
        Thread.sleep(3000);
        s.selectByValue("Monday");
        Thread.sleep(3000);
        s.selectByVisibleText("Friday");
        Thread.sleep(3000);

        System.out.println(s.getAllSelectedOptions().size());
        System.out.println(s.getOptions().size());

        WebElement mulSelect = driver.findElement(By.id("multi-select"));
        Select s1 = new Select(mulSelect);
        if(s1.isMultiple()){
            s1.selectByIndex(2);
            s1.selectByValue("Ohio");
            s1.selectByVisibleText("Washington");
            Thread.sleep(3000);

            s1.deselectAll();
        }
        driver.close();
    }
}
