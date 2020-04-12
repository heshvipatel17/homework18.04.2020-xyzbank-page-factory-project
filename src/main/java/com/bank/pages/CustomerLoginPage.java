package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
    By searchCreatedcustomerName = By.xpath("//select[@id='userSelect']");
    By loginBtn = By.xpath("//button[@class='btn btn-default']");

    By verifyYourNameText = By.xpath("//label[contains(text(),'Your Name :')]");

//    public void clickOnSearchCreatedCustomerName() {
//        clickOnElement(searchCreatedcustomerName);
//        selectByVisibleTextFromDropDown(searchCreatedcustomerName, "Jitu Patel");
//    }
//    public void clickOnSearchCustomerField() {
//        clickOnElement(searchCreatedcustomerName);
//    }
//
//    public void enterCustomerThatCreatedInFirstTest() {
//        selectByVisibleTextFromDropDown(searchCustomerField, "Jitu Patel");
//
//    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
    }



    public void assertYourNameText() {
        verifyText(verifyYourNameText, "Your Name :");
    }
}
