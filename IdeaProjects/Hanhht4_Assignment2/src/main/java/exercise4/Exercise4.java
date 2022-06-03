package exercise4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.Locale;

public class Exercise4 {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.ie.driver","D:\\WebDriver\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.lazada.vn/");

        driver.manage().window().maximize();

        //Nếu so sánh không phân biệt hoa thường
        //String title = driver.getTitle().toLowerCase(Locale.ROOT);
        //if (title.contains("LAZADA".toLowerCase(Locale.ROOT))) {

        //Nếu so sánh chính xác
        String title = driver.getTitle();
        if (title.contains("LAZADA")) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
            System.out.println("Actual title is: " + title);
        }
        Thread.sleep(500);
        driver.close();
    }
}
