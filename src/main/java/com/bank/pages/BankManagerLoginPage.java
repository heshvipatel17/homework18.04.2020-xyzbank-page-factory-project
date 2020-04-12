package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {

    By addCustomerLink = By.xpath("//button[contains(text(),'Add Customer')]");
    By openAccountLink = By.xpath("//button[contains(text(),'Open Account')]");
    By customersLink = By.xpath("//button[contains(text(),'Customers')]");


    public void clickOnAddCustomerLink() {
        clickOnElement(addCustomerLink);

    }

    public void clickOnOpenAccountLink() {
        clickOnElement(openAccountLink);
    }

    public void clickOnCustomersLink() {
        clickOnElement(customersLink);
    }

}
