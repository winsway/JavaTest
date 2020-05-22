/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.lion.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author winsway
 */
public class PerformanceTestTest {

    public PerformanceTestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testArray method, of class PerformanceTest.
     */
    @Test
    public void testTestArray() {
        System.out.println("testArray");
        List<String> list = null;
        PerformanceTest.testArray(list);

    }

    /**
     * Test of testList method, of class PerformanceTest.
     */
    @Test
    public void testTestList() {
        System.out.println("testList");
        List<String> list = null;
        PerformanceTest.testList(list);

    }

    /**
     * Test of test method, of class PerformanceTest.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        PerformanceTest.Test[] tests = null;
        List<String> list = null;
        PerformanceTest.test(tests, list);

    }

    /**
     * Test of main method, of class PerformanceTest.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PerformanceTest.main(args);
    }

}
