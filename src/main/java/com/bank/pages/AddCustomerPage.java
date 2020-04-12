package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddCustomerPage extends Utility {

    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postCodeField = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerbtn = By.xpath("//button[@class='btn btn-default']");

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
    }

    public void enterPostCode(String postCode) {
        sendTextToElement(postCodeField, postCode);
    }

    public void clickOnAddCustomerButton() {
        waitUntilElementToBeClickable(addCustomerbtn, 5);
        clickOnElement(addCustomerbtn);
    }

    public void verifyMessageFromPopupOnAddCustomerPage(String str) {
        String actualMessage = alertGetText();
        String expectedMessage = "Customer added successfully with customer id :";
        Assert.assertTrue(actualMessage.contains(expectedMessage), str);

    }

}
