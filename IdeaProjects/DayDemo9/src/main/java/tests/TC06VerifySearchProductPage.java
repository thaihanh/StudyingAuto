package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;

public class TC06VerifySearchProductPage extends BaseTest {
    @Test(dataProvider = "testdata")
    public void tc06VerifySearchProductPage(String url, String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        CustomersPage customersPage = new CustomersPage(getDriver());
        loginPage.navigateToLogin(url);
        getDriver().manage().window().maximize();
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.login(username, password);
        Assert.assertTrue(dashboardPage.verifyDashboard());
        //4. Click to the Customers on the left menu.
        Assert.assertTrue(dashboardPage.verifyDashboard());
        if (dashboardPage.verifyIncomingMsg()) {
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
    @DataProvider(name = "testdata")
    public Object[][] getTestData(){
        return ExcelUtils.getTableArray("D:\\dataTest.xlsx", "TC01", 0, 3);
    }

}
