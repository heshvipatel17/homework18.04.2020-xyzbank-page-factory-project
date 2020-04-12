package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By verifylogOutText = By.xpath("//button[@class='btn logout']");

    By depositeTab = By.xpath("//button[contains(text(),'Deposit')]");
    By amountToBeDepositedField = By.xpath("//input[@placeholder='amount']");
    By depositebtn = By.xpath("//button[@class='btn btn-default']");
    By verifyDepositSuccessfulText = By.xpath("//span[@class='error ng-binding']");

    By withdrawlTab = By.xpath("//button[contains(text(),'Withdrawl')]");
    By amountToBeWithdrawlsField = By.xpath("//input[@placeholder='amount']");
    By withdrawlBtn = By.xpath("//button[@class='btn btn-default']");
    By verifyTransactionSuccessfulText = By.xpath("//span[@class='error ng-binding']");

    public void assertLogOutText() {
        verifyText(verifylogOutText, "Logout");
    }

    public void clickOnLogOutButton() {
        clickOnElement(verifylogOutText);
    }

    // Method for click ondeposit tab
    public void clickOnDepositeTab() {
        clickOnElement(depositeTab);
    }

    // Method for enter deposit field
    public void enterdDepositAmount100(int amount) {
        sendTextToElement(this.amountToBeDepositedField, String.valueOf(amount));
    }

    // Method for Click on deposit button
    public void clickOnDepositeButton(){
        clickOnElement(depositebtn);
    }
    public void assertDepositeSuccessfulText(){
        verifyText(verifyDepositSuccessfulText, "Deposit Successful");
    }
    public void clickOnWithdrawlTab(){
        clickOnElement(withdrawlTab);
    }
    public void enterWithdrawlAmount50(){
        sendTextToElement(amountToBeWithdrawlsField,"50");
    }
    public void clicOnWithdrawlButton(){
        clickOnElement(withdrawlBtn);
    }
    public void assertTransactionSuccessfulText(){
        verifyText(verifyTransactionSuccessfulText, "Transaction successful");
    }
}
