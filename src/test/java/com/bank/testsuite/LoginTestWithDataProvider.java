package com.bank.testsuite;

import com.bank.pages.AddCustomerPage;
import com.bank.pages.BankManagerLoginPage;
import com.bank.pages.HomePage;
import com.bank.testbase.TestBase;
import com.bank.testdata.TestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestWithDataProvider extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;

    @BeforeMethod(groups = {"Regression", "Smoke", "Sanity"})
    public void setUp() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
    }

    @Test(groups = {"Sanity", "Regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void doLogin(String fName, String lName, String pCode) {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerLink();
        addCustomerPage.addcustomerData(fName, lName, pCode);

    }

}
