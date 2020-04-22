package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement _firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement _lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement _postCodeField;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement _addCustomerbtn;

    public void enterFirstName(String firstName) {
        Reporter.log(" Enter first name " + firstName + " to the first name field" + _firstNameField.toString() + "<br>");
        sendTextToElement(_firstNameField, firstName);
        log.info(" Enter first name " + firstName + " to the first name field" + _firstNameField.toString());
    }

    public void enterLastName(String lastName) {
        Reporter.log(" Enter last name " + lastName + " to the last name field" + _lastNameField.toString() + "<br>");
        sendTextToElement(_lastNameField, lastName);
        log.info(" Enter last name " + lastName + " to the last name field" + _lastNameField.toString());
    }

    public void enterPostCode(String postCode) {
        Reporter.log(" Enter post code " + postCode + " to the post code field" + _postCodeField.toString() + "<br>");
        sendTextToElement(_postCodeField, postCode);
        log.info(" Enter post code " + postCode + " to the post code field" + _postCodeField.toString());
    }

    public void clickOnAddCustomerButton() {
        Reporter.log(" Clicking on add customer button " + _addCustomerbtn.toString() + "<br>");
        waitUntilElementToBeClickable(_addCustomerbtn, 10);
        clickOnElement(_addCustomerbtn);
//        log.info(" Clicking on add customer button " + _addCustomerbtn.toString());
    }

    public void verifyMessageFromPopupOnAddCustomerPage(String str) {

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Customer added successfully with customer id :";
        Assert.assertTrue(actualMessage.contains(expectedMessage), str);
    //    alertAccept();

    }

    public void addcustomerData(String fName, String lName, String pCode) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostCode(pCode);
        clickOnAddCustomerButton();

    }

}
