package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomersPage extends Utility {

    By searchCustomerField = By.xpath("//input[@placeholder='Search Customer']");
    By deleteCustomer = By.xpath("//button[contains(text(),'Delete')]");

    public void clickOnSearchCustomerField() {
        clickOnElement(searchCustomerField);
    }

    public void enterCustomerThatCreatedInCustomerPage(String str) {
        sendTextToElement(searchCustomerField, str);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteCustomer);
    }


}
