package com.bank.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        return new Object[][]{
                {"Shree","Ram","Swarg1"},
                {"Shree","Krishna","Swarg2"},
                {"Shree","Ganesh","Swarg3"}

        };
    }

}


