package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomersPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement _searchCustomerField;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement _deleteCustomer;

    public void clickOnSearchCustomerField() {
        Reporter.log(" Clicking on search customer field" + _searchCustomerField.toString() + "<br>");
        clickOnElement(_searchCustomerField);
        log.info(" Clicking on search customer field" + _searchCustomerField.toString());
    }

    public void enterCustomerThatCreatedInCustomerPage(String customerField) {
        Reporter.log(" Enter text " + customerField + " to search customer field" + _searchCustomerField.toString() + "<br>");
        sendTextToElement(_searchCustomerField, customerField);
        log.info(" Enter text " + customerField + " to search customer field" + _searchCustomerField.toString());
    }

    public void clickOnDeleteButton() {
        Reporter.log(" Delete customer " + _deleteCustomer.toString() + "<br>");
        clickOnElement(_deleteCustomer);
        log.info(" Delete customer " + _deleteCustomer.toString());
    }


}
