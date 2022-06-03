package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercise1 {
    @Test
    public void Test() throws InterruptedException {

        //Step 1
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tiki.vn/");

        driver.manage().window().maximize();

        //Step 2
        //Nếu so sánh không phân biệt hoa thường
        //String title = driver.getTitle().toLowerCase(Locale.ROOT);
        //if (title.contains("amazon.com".toLowerCase(Locale.ROOT))) {

        //Nếu so sánh chính xác
        String title = driver.getTitle();
        if (title.contains("tiki.vn")) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
            System.out.println("Actual title is: " + title);
        }

        //Step 3
        WebElement searchBox = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
        searchBox.sendKeys("Smartphone");

        WebElement btnSearch = driver.findElement(By.xpath("//button[@data-view-id=\"main_search_form_button\"]"));
        btnSearch.click();
        Thread.sleep(3000);

        WebElement firstItem = driver.findElement(By.xpath("//div[@data-view-id='product_list_container']//a[@data-view-index='0']"));
        firstItem.click();
        Thread.sleep(3000);

        //Step 4
        String elementProductName = "//div[@class='header']//h1[@class='title']";
        if(isElementDisplayed(driver, elementProductName)){
            System.out.println("Product name is displayed");
        } else{
            System.out.println("Product name isn't displayed");
        }

        String elementPrice = "//div[@class='price-and-icon ']//div[@class='product-price__current-price']";
        if(isElementDisplayed(driver, elementPrice)){
            System.out.println("Price is displayed");
        } else{
            System.out.println("Price isn't displayed");
        }

    }
    public boolean isElementDisplayed(WebDriver driver, String yourLocator) {
        try {
            WebElement locator;
            locator = driver.findElement(By.xpath(yourLocator));
            return locator.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
