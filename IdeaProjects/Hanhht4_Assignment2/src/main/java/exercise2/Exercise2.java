package exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Exercise2 {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tiki.vn/");

        driver.manage().window().maximize();
        String title = driver.getTitle();
        if (title.contains("tiki.vn")) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
            System.out.println("Actual title is: " + title);
        }
        Thread.sleep(500);
        driver.close();
    }
}
