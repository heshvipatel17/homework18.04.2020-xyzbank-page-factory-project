package com.bank.TesstNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Jay
 */
public class TestNg_SoftAsserts {


    @Test
    public void testSum(){
        SoftAssert sa = new SoftAssert();
        int a = 10;
        int b = 20;
        int result = a+b;
        System.out.println("\nRunning Test -> testSum");
        sa.assertTrue(result==40);
        System.out.println("\nLine after assert 1");
        sa.assertTrue(result == 30);
        System.out.println("\nLine after assert 2");
        sa.assertAll();
    }
}
