package com.bank.testsuite;

import com.bank.loadproperty.LoadProperty;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    String firstName = null;
    String lastName = null;

    LoadProperty loadProperty = new LoadProperty();
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomersPage customersPage = new CustomersPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    AccountPage accountPage = new AccountPage();

    @BeforeTest
    public void setUp() {
        firstName = getRandomString(4);
        lastName = getRandomString(5);
    }

    @Test(priority = 0)
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerLink();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("HA3");
        addCustomerPage.clickOnAddCustomerButton();
//        Alert alert = driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
        addCustomerPage.verifyMessageFromPopupOnAddCustomerPage("Customer added successfully with customer id :");
        alertAccept();
    }

    @Test(priority = 1)
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnOpenAccountLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
        openAccountPage.clickOnSearchCurrencyField();
        openAccountPage.clickOnSearchCurrencyFieldPound("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyMessageFromPopupOnOpenAccountPage("Account created successfully with account Number :");
        alertAccept();
    }

    @Test(priority = 2)
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
        //  customerLoginPage.clickOnSearchCreatedCustomerName();
        customerLoginPage.clickOnLoginButton();
        accountPage.assertLogOutText();
        accountPage.clickOnLogOutButton();
        customerLoginPage.assertYourNameText();
    }

    @Test(priority = 3)
    public void customerShouldDepositeMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
//        customerLoginPage.clickOnSearchCreatedCustomerName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositeTab();
        accountPage.enterdDepositAmount100(100);
        accountPage.clickOnDepositeButton();
        accountPage.assertDepositeSuccessfulText();
    }

    @Test(priority = 4)
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
        //  customerLoginPage.clickOnSearchCreatedCustomerName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount50();
        accountPage.clicOnWithdrawlButton();
        accountPage.assertTransactionSuccessfulText();


    }

    @Test(priority = 5)
    public void bankManagerShouldDeleteCustomerSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnCustomersLink();
        customersPage.clickOnSearchCustomerField();
        customersPage.enterCustomerThatCreatedInCustomerPage(firstName);
        customersPage.clickOnDeleteButton();
    }
}
