package com.bank.TesstNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay
 */
@Listeners(TestNGListeners.class)
public class TestNGListenersDemo {

    @Test
    public void test1(){
        System.out.println("I am inside Test1");
    }

    @Test
    public void test2(){
        System.out.println("I am inside Test2");
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){
        System.out.println("I am inside Test3");
        throw  new SkipException("This test is skipped");
    }

}
