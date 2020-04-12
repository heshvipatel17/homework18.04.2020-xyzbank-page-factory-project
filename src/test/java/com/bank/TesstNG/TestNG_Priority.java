package com.bank.TesstNG;

import org.testng.annotations.Test;

/**
 * Created by Jay
 */
public class TestNG_Priority {

    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("TestNG_Priority -> testMethod1");
    }

    @Test(priority = 2)
    public void testMethod2() {
        System.out.println("TestNG_Priority -> testMethod2");
    }

    @Test(priority = 3)
    public void testMethod3() {
        System.out.println("TestNG_Priority -> testMethod3");
    }

    @Test()
    public void testMethod4() {
        System.out.println("TestNG_Priority -> testMethod4");
    }
}
