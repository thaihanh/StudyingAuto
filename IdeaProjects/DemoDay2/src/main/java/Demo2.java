import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {
    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/majorleague/control/newcustomer");

        driver.manage().window().maximize();

        //Account Information
        WebElement email = driver.findElement(By.name("CUSTOMER_EMAIL"));
        email.sendKeys("hanh@gmail.com");

        WebElement username = driver.findElement(By.name("USERNAME"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.name("PASSWORD"));
        password.sendKeys("123456");

        WebElement confirmPassword = driver.findElement(By.name("CONFIRM_PASSWORD"));
        confirmPassword.sendKeys("123456");

        WebElement hintPassword = driver.findElement(By.name("PASSWORD_HINT"));
        hintPassword.sendKeys("a");

        //Personal Information
        WebElement firstName = driver.findElement(By.name("USER_FIRST_NAME"));
        firstName.sendKeys("Hoang");

        WebElement middleName = driver.findElement(By.name("USER_MIDDLE_NAME"));
        middleName.sendKeys("Thai");

        WebElement lastName = driver.findElement(By.name("USER_LAST_NAME"));
        lastName.sendKeys("Hanh");

        WebElement suffix = driver.findElement(By.name("USER_SUFFIX"));
        firstName.sendKeys("4");

        //Location
        WebElement address1 = driver.findElement(By.name("CUSTOMER_ADDRESS1"));
        address1.sendKeys("address1");

        WebElement address2 = driver.findElement(By.name("CUSTOMER_ADDRESS2"));
        address2.sendKeys("address2");

        WebElement city = driver.findElement(By.name("CUSTOMER_CITY"));
        city.sendKeys("City Name");

        WebElement postalCode = driver.findElement(By.name("CUSTOMER_POSTAL_CODE"));
        postalCode.sendKeys("25254");

        //Phone - Home phone
        WebElement homeCountry = driver.findElement(By.name("CUSTOMER_HOME_COUNTRY"));
        address1.sendKeys("+84");

        WebElement homeArea = driver.findElement(By.name("CUSTOMER_HOME_AREA"));
        homeArea.sendKeys("25");

        WebElement homeContact = driver.findElement(By.name("CUSTOMER_HOME_CONTACT"));
        homeContact.sendKeys("2525");

        WebElement homeExt = driver.findElement(By.name("CUSTOMER_HOME_EXT"));
        homeExt.sendKeys("123");

        //Phone - Business phone
        WebElement workCountry = driver.findElement(By.name("CUSTOMER_WORK_COUNTRY"));
        workCountry.sendKeys("255");

        WebElement workArea = driver.findElement(By.name("CUSTOMER_WORK_AREA"));
        workArea.sendKeys("44");

        WebElement workContact = driver.findElement(By.name("CUSTOMER_WORK_CONTACT"));
        workContact.sendKeys("55");

        WebElement workExt = driver.findElement(By.name("CUSTOMER_WORK_EXT"));
        workExt.sendKeys("44");

        //Phone - Fax phone
        WebElement faxCountry = driver.findElement(By.name("CUSTOMER_FAX_COUNTRY"));
        faxCountry.sendKeys("55");

        WebElement faxArea = driver.findElement(By.name("CUSTOMER_FAX_AREA"));
        faxArea.sendKeys("4");

        WebElement faxContact = driver.findElement(By.name("CUSTOMER_FAX_CONTACT"));
        faxContact.sendKeys("55");

        //Phone - Mobile phone
        WebElement mobileCountry = driver.findElement(By.name("CUSTOMER_MOBILE_COUNTRY"));
        mobileCountry.sendKeys("555");

        WebElement mobileArea = driver.findElement(By.name("CUSTOMER_MOBILE_AREA"));
        mobileArea.sendKeys("444");

        WebElement mobileContact = driver.findElement(By.name("CUSTOMER_MOBILE_CONTACT"));
        mobileContact.sendKeys("44444");

        //WebElement loginButton = driver.findElement(By.id("field_id__7"));
        //loginButton.click();
        Thread.sleep(500);
        //driver.close();
    }
}
