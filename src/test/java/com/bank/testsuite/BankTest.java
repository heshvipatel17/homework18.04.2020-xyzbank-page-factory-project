package com.bank.testsuite;

import com.bank.loadproperty.LoadProperty;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    String firstName = null;
    String lastName = null;

    LoadProperty loadProperty;
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(groups = {"Regression", "Smoke", "Sanity"})
    public void setUp() {
        loadProperty = new LoadProperty();
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();

    }


    @BeforeTest(groups = {"Regression", "Sanity", "Smoke"})
    public void setUp1() {
        firstName = getRandomString(4);
        lastName = getRandomString(5);
    }

    @Test(priority = 0, groups = {"Sanity", "Smoke", "Regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerLink();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("HA3");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.verifyMessageFromPopupOnAddCustomerPage("Customer added successfully with customer id :");
        alertAccept();
    }

    @Test(priority = 1, groups = {"Sanity", "Regression"})
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

    @Test(priority = 2, groups = {"Sanity", "Regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
        customerLoginPage.clickOnLoginButton();
        accountPage.assertLogOutText("Logout");
        accountPage.clickOnLogOutButton();
        customerLoginPage.assertYourNameText("Your Name :");
    }

    @Test(priority = 3, groups = {"Smoke", "Regression"})
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
        accountPage.assertDepositeSuccessfulText("Deposit Successful");
    }

    @Test(priority = 4, groups = {"Smoke", "Regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest(firstName + " " + lastName);
        //  customerLoginPage.clickOnSearchCreatedCustomerName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount50("50");
        accountPage.clicOnWithdrawlButton();
        accountPage.assertTransactionSuccessfulText("Transaction successful");


    }

    @Test(priority = 5, groups = {"Smoke", "Regression"})
    public void bankManagerShouldDeleteCustomerSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnCustomersLink();
        customersPage.clickOnSearchCustomerField();
        customersPage.enterCustomerThatCreatedInCustomerPage(firstName);
        customersPage.clickOnDeleteButton();
    }


}
