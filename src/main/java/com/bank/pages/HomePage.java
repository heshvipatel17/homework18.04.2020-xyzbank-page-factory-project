package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement _customerLoginLink;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement _bankManagerLoginLink;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement _homeButton;

    public void clickOnCustomerLoginLink() {
        clickOnElement(_customerLoginLink);
    }

    public void clickOnBankManagerLoginLink() {
        Reporter.log(" Clicking on login link: " + _bankManagerLoginLink.toString() + "<br>");
        waitUntilElementToBeClickable(_bankManagerLoginLink, 5);
        clickOnElement(_bankManagerLoginLink);
        log.info("\" Clicking on login link: \" + _bankManagerLoginLink.toString()");
    }

    public void clickOnHomeButton() {
        Reporter.log(" Clicking on Home Button " + _homeButton.toString() + "<br>");
        clickOnElement(_homeButton);
        log.info(" Clicking on Home Button " + _homeButton.toString());
    }


}
