package demoDay6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alertLink = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#OKTab\"]")));
        alertLink.click();

        WebElement button = driver.findElement(By.xpath("button[@onclick=\"alertbox()\"]"));
        button.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Text:" + alert.getText());
        alert.accept();

        WebElement alertLinkCancel = driver.findElement(By.xpath("//a[@href=\"#CancelTab\"]"));
        alertLinkCancel.click();

        WebElement button2 = driver.findElement(By.xpath("button[@onclick=\"confirmbox()\"]"));
        button2.click();

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();

        WebElement alertLinkText = driver.findElement(By.xpath("//a[@href=\"#Textbox()\"]"));
        alertLinkText.click();

        WebElement button3 = driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]"));
        button3.click();

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("demo");
        alert3.dismiss();
        driver.close();
    }
}
