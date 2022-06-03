package demo;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;

public class Cookies {
    @Test
    public void test() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tiki.vn/");
        Thread.sleep(4000);
        Set<Cookie> lsCookie = driver.manage().getCookies();
        for (Cookie c : lsCookie){
            System.out.println(c.getPath());
            System.out.println(c.getName());
        }
//        Cookie cookie = driver.manage().getCookieNamed("APISID");
//        System.out.println("cookie:"+cookie.getValue());
//        Cookie cookie2 = driver.manage().getCookieNamed("APISID");
//        System.out.println("cookie2:"+cookie2.getValue());
        driver.close();
    }
}
