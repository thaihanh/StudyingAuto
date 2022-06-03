package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Day4c {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        List<WebElement> ls = driver.findElements(By.name("optradio"));
        for (WebElement element: ls){
            if(!element.isSelected()){
                if(element.getAttribute("value").equals("Male")){
                    element.click();
                }
            }
        }
        Thread.sleep(4000);
        driver.navigate().to("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        Thread.sleep(4000);
        driver.close();
    }
}
