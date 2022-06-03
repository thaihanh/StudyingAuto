package exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Locale;

public class Exercise3 {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

        //Nếu so sánh không phân biệt hoa thường
        //String title = driver.getTitle().toLowerCase(Locale.ROOT);
        //if (title.contains("amazon.com".toLowerCase(Locale.ROOT))) {

        //Nếu so sánh chính xác
        String title = driver.getTitle();
        if (title.contains("amazon.com")) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
            System.out.println("Actual title is: " + title);
        }
        Thread.sleep(500);
        driver.close();
    }
}
