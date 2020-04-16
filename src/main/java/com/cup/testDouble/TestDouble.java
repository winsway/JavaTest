/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.testDouble;

/**
 * 用于测试 double 和 Double的计算速度
 *
 * @author winsway
 */
public class TestDouble {

    /**
     * 测试double 和 Double的计算速度
     */
    public void testSpeed() {
        double doubleNum = 0;
        Double A = 0.0;
        int loopCount = 1000000000;
        //计算double类型数据的循环耗时
        long timer1 = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            doubleNum += 1.80;
        }
        long timer2 = System.currentTimeMillis();
        System.out.printf("循环%dW次的合计值: %f\n", loopCount / 10000, doubleNum);
        System.out.println("总共耗时为: " + (timer2 - timer1) + "毫秒");
        //计算Double类型数据的循环耗时
        long timer3 = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            A += 1.80;
        }
        long timer4 = System.currentTimeMillis();
        System.out.printf("循环%dW次的合计值: %f\n", loopCount / 10000, A);
        System.out.println("总共耗时为: " + (timer4 - timer3) + "毫秒");
    }

}
