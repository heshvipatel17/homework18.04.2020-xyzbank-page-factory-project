package com.bank.TesstNG;

import org.testng.annotations.Test;

/**
 * Created by Jay
 */
public class TestNG_Grouping {


    @Test(groups = {"sanity" ,"smoke"})
    public void loginTest1(){
        System.out.println("Running test - loginTest1");
    }

    @Test(groups = {"smoke"})
    public void loginTest2(){
        System.out.println("Running test - loginTest2");
    }

    @Test(groups = {"Regression"})
    public void loginTest3(){
        System.out.println("Running test - loginTest3");
    }

    @Test(groups = {"Regression"})
    public void loginTest4(){
        System.out.println("Running test - loginTest4");
    }

    @Test(groups = {"sanity", "smoke"})
    public void registrationTest1(){
        System.out.println("Running test - registrationTest1");
    }

    @Test(groups = {"Regression"})
    public void registrationTest2(){
        System.out.println("Running test - registrationTest2");
    }

    @Test(groups = {"sanity", "smoke"})
    public void computerTest1(){
        System.out.println("Running test - computerTest1");
    }

    @Test(groups = {"Regression"})
    public void computerTest2(){
        System.out.println("Running test - computerTest1");
    }
}
