package com.bank.testbase;

import com.bank.browserselector.BrowserSelector;
import com.bank.loadproperty.LoadProperty;
import com.bank.utility.Utility;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase extends Utility {

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();

    String baseUrl = loadProperty.getProperty("baseUrl");
    String browser = loadProperty.getProperty("browser");

    @BeforeTest(groups = {"Regression","Sanity","Smoke"})
    public void openBrowser() {
        browserSelector.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterTest (groups = {"Regression","Sanity","Smoke"})
    public void tearDown() {
        driver.quit();
    }
}
