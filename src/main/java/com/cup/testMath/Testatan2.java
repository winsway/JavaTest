/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.testMath;

/**
 *
 * @author winsway
 */
public class Testatan2 {

    /**
     * 测试角度
     */
    public void testAtan2() {
        System.out.println("test -pi/2");
        System.out.println("test -pi/2 = " + Math.atan2(-1, 0));
        System.out.println("test 0");
        System.out.println("test 0 = " + Math.atan2(0, 1));
        System.out.println("test pi/2");
        System.out.println("test pi/2 = " + Math.atan2(1, 0));
        System.out.println("test pi");
        System.out.println("test pi = " + Math.atan2(0, -1));
        System.out.println("test -pi");
        System.out.println("test -pi = " + Math.atan2(-0.0, -1));
        System.out.println("test 3/2pi");
        System.out.println("test 3/2pi = " + Math.atan2(-1 + 1.E-40, 0));
        System.out.println("test 3/4pi");
        System.out.println("test 3/4pi = " + Math.atan2(1, -1));
    }

}
