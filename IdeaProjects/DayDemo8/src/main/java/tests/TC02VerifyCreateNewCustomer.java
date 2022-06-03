package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;

public class TC02VerifyCreateNewCustomer extends BaseTest {
    @Test
    public void tc02VerifyCreateNewCustomer(){
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        CustomersPage customersPage = new CustomersPage(getDriver());
        //1. Open the browser for scipioerp website: http://139.162.47.20/magento222/admin
        loginPage.navigateToLogin("http://139.162.47.20/magento222/admin");
        getDriver().manage().window().maximize();
        //2. input username: admin and password: admin123
        //3. Click to Signin button
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.login("admin","admin123");
        //4. Click to the Customers on the left menu.
        Assert.assertTrue(dashboardPage.verifyDashboard());
        if(dashboardPage.verifyIncomingMsg()){
            dashboardPage.clickCloseMsg();
        }
        Assert.assertTrue(dashboardPage.verifyMenuLeft());
        dashboardPage.clickCustomersMenuItem();
        //5. Click to the All Customers
        dashboardPage.clickAllCustomersSubMenu();
        //6. Click Add New Customer
        Assert.assertTrue(customersPage.verifyCustomer());
        customersPage.clickAddNewCustomerBtn();
        //7. Input the requite field.

        //8. Click to the Save Customer.

    }
}
