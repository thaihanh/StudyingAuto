import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;

public class Exercise4 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(4000);
        Set<Cookie> lsCookie = driver.manage().getCookies();
        for (Cookie c : lsCookie){
            System.out.println(c.getPath());
            System.out.println(c.getName());
        }
        driver.close();
    }
}
