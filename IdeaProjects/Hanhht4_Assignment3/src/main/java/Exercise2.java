import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 {
    @Test
    public void exercise2() throws InterruptedException {
        //Step 1
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.walmart.com/ip/VIZIO-70-Class-4K-UHD-LED-SmartCast-Smart-TV-HDR-V-Series-V705-G3/936515428");

//        driver.manage().window().maximize();
//        String actualUrl = "https://www.walmart.com/ip/VIZIO-70-Class-4K-UHD-LED-SmartCast-Smart-TV-HDR-V-Series-V705-G3/936515428";
//        String expectedUrl = driver.getCurrentUrl();
//        Assert.assertEquals(expectedUrl, actualUrl);
//        System.out.println("Navigate to page successfully");

//        WebElement closedialogBtn = driver.findElement(By.xpath("//button[@class='w_Iq' and @aria-label = 'Close dialog']"));
//        if (closedialogBtn.isDisplayed()) {
//            closedialogBtn.click();
//            Thread.sleep(3000);
//        }
        //Step 2: Write the selectors of element by Id, Name, Class, XPath as below
        // Title product
        WebElement titleProduct = driver.findElement(By.xpath("//div[@class='w_CK w_DJ w_CO']//h1[@itemprop='name']"));
        Assert.assertTrue(titleProduct.isDisplayed());
        //Price of product
        WebElement priceProduct = driver.findElement(By.xpath("//span[@itemprop='price']"));
        Assert.assertTrue(priceProduct.isDisplayed());
        //Free shipping info
        WebElement freeShippingInfo = driver.findElement(By.xpath("//div[@class='w_CK w_DJ w_CO']//div[@class='f6 bw0-xl b--near-white ml3 mr3 mid-gray ml0-m mr0-m']"));
        Assert.assertTrue(freeShippingInfo.isDisplayed());
        //None tab, 2 Year tab => Khong tim thay tren web
        //Add to Cart button
        WebElement addToCartBtn = driver.findElement(By.xpath("//span[text()='Add to cart']//parent::button"));
        Assert.assertTrue(addToCartBtn.isDisplayed());
        addToCartBtn.click();
        WebElement closePanelBtn = driver.findElement(By.xpath("//div[@role='dialog' and @class='w_IR w_IT']//button[@aria-label='Close panel']"));
        closePanelBtn.click();
        //Qty combobox
        WebElement qtyCombobox = driver.findElement(By.xpath("//div[@data-testid='quantity-stepper']//.."));
        Assert.assertTrue(qtyCombobox.isDisplayed());
        //Add to list
        WebElement addToListBtn = driver.findElement(By.xpath("///div[@class='w_CK w_DJ w_CO']//button[text()='Add to list']"));
        Assert.assertTrue(addToListBtn.isDisplayed());
        //Add to Registry
        WebElement addToRegisterBtn = driver.findElement(By.xpath("//div[@class='w_CK w_DJ w_CO']//button[text()='Add to registry']"));
        Assert.assertTrue(addToRegisterBtn.isDisplayed());
        driver.close();
    }
}
