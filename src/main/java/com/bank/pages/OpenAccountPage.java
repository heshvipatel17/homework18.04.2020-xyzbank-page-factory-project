package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OpenAccountPage extends Utility {

//    By openAccountTab = By.xpath("//button[contains(text(),'Open Account')]");
    By searchCustomerField = By.xpath("//select[@id='userSelect']");
    By searchCurrencyPound = By.xpath("//select[@id='currency']");
    By processBtn = By.xpath("//button[contains(text(),'Process')]");

//    public void clickOnOpenAccountTab() {
//        clickOnElement(openAccountTab);
//    }

    public void clickOnSearchCustomerField() {
        clickOnElement(searchCustomerField);
    }

    public void enterCustomerThatCreatedInFirstTest(String cusName) {
        selectByVisibleTextFromDropDown(searchCustomerField, cusName);

    }

    public void clickOnSearchCurrencyField() {
        clickOnElement(searchCurrencyPound);
    }

    public void clickOnSearchCurrencyFieldPound(String str) {
        selectByVisibleTextFromDropDown(searchCurrencyPound, str);
    }

    public void clickOnProcessButton() {
        clickOnElement(processBtn);
    }

    public void verifyMessageFromPopupOnOpenAccountPage(String str) {
        String actualMessage = alertGetText();
        String expectedMessage = "Account created successfully with account Number :";
        Assert.assertTrue(actualMessage.contains(expectedMessage), str);

    }

    public void clickOkToPopUpButtonOnOpenAccountPage() {
        alertAccept();
    }

//    select.selectByVisibleText("Benz");
//    select.selectByValue("honda");
}
