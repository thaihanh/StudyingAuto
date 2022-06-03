package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewCustomerPage;

public class TC02VerifyCreateNewCustomer extends BaseTest {
    @Test(dataProvider = "testdata")
    public void tc02VerifyCreateNewCustomer(String url, String username, String password, String associateToWebsite,
                                            String group, String firstName, String lastName, String email){
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        CustomersPage customersPage = new CustomersPage(getDriver());
        NewCustomerPage newCustomerPage = new NewCustomerPage(getDriver());
        //1. Open the browser for scipioerp website: http://139.162.47.20/magento222/admin
        loginPage.navigateToLogin(url);
        getDriver().manage().window().maximize();
        //2. input username: admin and password: admin123
        //3. Click to Sign in button
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.login(username,password);
        //4. Click to the Customers on the left menu.
        Assert.assertTrue(dashboardPage.verifyDashboard());
        if(dashboardPage.verifyIncomingMsg()){
            dashboardPage.clickCloseMsg();
        }
        Assert.assertTrue(dashboardPage.verifyMenuLeft());
        dashboardPage.clickCustomersMenuItem();
        //5. Click to the all Customers
        dashboardPage.clickAllCustomersSubMenu();
        //6. Click Add New Customer
        Assert.assertTrue(customersPage.verifyCustomer());
        customersPage.clickAddNewCustomerBtn();
        //7. Input the required field.
        Assert.assertTrue(newCustomerPage.verifyNewCustomer());
        newCustomerPage.inputRequiredField(associateToWebsite, group, firstName, lastName, email);
        //8. Click to the Save Customer.
        newCustomerPage.clickSaveBtn();
        customersPage.verifyMsg();
    }
    @DataProvider(name = "testdata")
    public Object[][] getTestData(){
        return ExcelUtils.getTableArray("D:\\dataTest.xlsx", "TC02", 0, 8);
    }
}
