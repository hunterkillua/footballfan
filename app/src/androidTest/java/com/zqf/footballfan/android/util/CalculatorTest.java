package com.zqf.footballfan.android.util;

import junit.framework.TestCase;

/**
 * Created by liyan on 16/2/19.
 */
public class CalculatorTest extends TestCase {

    private Calculator mCalculator;

    @Override
    protected void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    public void testSum() throws Exception {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    public void testSubstract() throws Exception {
        assertEquals(1d, mCalculator.substract(5d, 4d), 0);
    }

    public void testDivide() throws Exception {

    }

    public void testMultiply() throws Exception {

    }
}