package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement _searchCustomerField;

    @FindBy(xpath = "//select[@id='currency']" )
    WebElement _searchCurrencyPound;

    @FindBy(xpath = "//button[contains(text(),'Process')]" )
    WebElement _processBtn;


    public void clickOnSearchCustomerField() {
        Reporter.log(" Clicking on search customer field" + _searchCustomerField.toString() + "<br>");
        clickOnElement(_searchCustomerField);
        log.info(" Clicking on search customer field" + _searchCustomerField.toString());
    }

    public void enterCustomerThatCreatedInFirstTest(String cusName) {
        Reporter.log(" Enter name" + cusName+" on customer name field "+ _searchCustomerField.toString()+"<br>");
        selectByVisibleTextFromDropDown(_searchCustomerField, cusName);
        log.info(" Enter name" + cusName+" on customer name field "+ _searchCustomerField.toString());

    }

    public void clickOnSearchCurrencyField() {
        Reporter.log(" clicking on Pound currency field" + _searchCurrencyPound.toString()+"<br>");
        clickOnElement(_searchCurrencyPound);
        log.info(" clicking on Pound currency field" + _searchCurrencyPound.toString());
    }

    public void clickOnSearchCurrencyFieldPound(String poundField) {
        Reporter.log("Search Pound field" + poundField+" from currency " + _searchCurrencyPound.toString()+"<br>");
        selectByVisibleTextFromDropDown(_searchCurrencyPound, poundField);
        log.info("Search Pound field" + poundField+" from currency " + _searchCurrencyPound.toString());
    }

    public void clickOnProcessButton() {
        Reporter.log("Clicking on process button" + _processBtn.toString()+"<br>");
        clickOnElement(_processBtn);
    //    log.info("Clicking onprocess button" + _processBtn.toString());
    }

    public void verifyMessageFromPopupOnOpenAccountPage(String str) {
        String actualMessage = alertGetText();
        String expectedMessage = "Account created successfully with account Number :";
        Assert.assertTrue(actualMessage.contains(expectedMessage), str);
    //    alertAccept();


    }

}
