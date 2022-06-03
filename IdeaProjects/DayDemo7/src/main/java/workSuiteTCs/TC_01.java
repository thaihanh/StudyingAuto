package workSuiteTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TC_01 {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browserName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browserName);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }
    @Test
    public void verifyDashboard() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().get("https://demo.worksuite.biz/login");
        getDriver().manage().window().maximize();
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");
        WebElement password = getDriver().findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement loginBtn = getDriver().findElement(By.id("submit-login"));
        loginBtn.click();
        getDriver().manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[contains(text(),'Dashboard')])[1]")));

        //Menu Left
        WebElement menuLeft = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']"));
        menuLeft.isDisplayed();
        WebElement adminDashboard = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/dashboard']"));
        adminDashboard.isDisplayed();
        WebElement privateDashboard = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href=" +
                "'https://demo.worksuite.biz/account/dashboard-member']"));
        privateDashboard.isDisplayed();
        WebElement leads = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/leads']"));
        leads.isDisplayed();
        WebElement clients = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/clients']"));
        clients.isDisplayed();
        WebElement hr = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@title='HR']"));
        hr.isDisplayed();
        WebElement work = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@title='Work']"));
        work.isDisplayed();
        WebElement finance = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@title='Finance']"));
        finance.isDisplayed();
        WebElement products = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/products']"));
        products.isDisplayed();
        WebElement orders = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/orders']"));
        orders.isDisplayed();
        WebElement tickets = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/tickets']"));
        tickets.isDisplayed();
        WebElement events = getDriver().findElement(By.xpath("//div[@id='sideMenuScroll']//a[@href='https://demo.worksuite.biz/account/events']"));
        events.isDisplayed();
        //Menu Top
        WebElement menuTop = getDriver().findElement(By.xpath("//div[@class='d-flex filter-box project-header bg-white dashboard-header']"));
        menuTop.isDisplayed();
        WebElement overview = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        overview.isDisplayed();
        WebElement project = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        project.isDisplayed();
        WebElement client1 = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        client1.isDisplayed();
        WebElement hr1 = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        hr1.isDisplayed();
        WebElement ticket1 = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        ticket1.isDisplayed();
        WebElement finance1 = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        finance1.isDisplayed();
        //Widget
        WebElement totalClient = getDriver().findElement(By.xpath("//a[@href='https://demo.worksuite.biz/account/dashboard?tab=overview']"));
        totalClient.isDisplayed();







    }
    @AfterTest
    public void afterTest() {
        driverThreadLocal.remove();
    }
}

