package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By customerLoginLink = By.xpath("//button[contains(text(),'Customer Login')]");
    By bankManagerLoginLink = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    By homeButton = By.xpath("//button[@class='btn home']");

    public void clickOnCustomerLoginLink() {
        clickOnElement(customerLoginLink);
    }

    public void clickOnBankManagerLoginLink() {
        waitUntilElementToBeClickable(bankManagerLoginLink, 5);
        clickOnElement(bankManagerLoginLink);
    }

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
    }


}
