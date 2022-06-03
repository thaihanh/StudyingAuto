package demoDay6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test3 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tab = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#Seperate\"]")));
        tab.click();

        WebElement click = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"newwindow()\"]")));
        click.click();

        for (String windows : driver.getWindowHandles()) {
            driver.switchTo().window(windows);
            if (driver.getTitle().equals("Selenium")) {
                break;
            }
        }

        WebElement download = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_navbar']//a[@href=\"/downloads\"]")));
        download.click();
        driver.close();
    }
}
