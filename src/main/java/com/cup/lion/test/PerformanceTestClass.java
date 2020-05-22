/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.lion.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * <p>
 * 程序分别对Java数组、ArrayList、LinkedList和Vector进行随机访问和迭代等操作， 并比较这种集合 的性能。
 * </p>
 * <p>
 * 从结果可以看出，对数组进行随机访问和迭代操作的速度是最快的； 对LinkedList进行插入和删除操作的速度是最快的；
 * 对ArrayList进行随机访问的速度也很快；Vector类在各方面没有突出的性能，且此类已不提倡使用了。</p>
 *
 * @see https://www.cnblogs.com/vijozsoft/p/5813693.html
 * @author winsway
 */
public class PerformanceTestClass {

    private static final int SIZE = 100000;

    public static abstract class Test {

        private final String operation;

        public Test(String operation) {
            this.operation = operation;
        }

        public abstract void test(List<Double> list);

        public String getOperation() {
            return operation;
        }
    }
    //执行迭代操作的匿名类
    static Test iterateTest = new Test("iterate") {
        @Override
        public void test(List<Double> list) {
            for (int i = 0; i < 10; i++) {
                Iterator<Double> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    //执行随机访问的匿名类
    static Test getTest = new Test("get") {
        @Override
        public void test(List<Double> list) {
            for (int i = 0; i < list.size(); i++) {
                for (int k = 0; k < 10; k++) {
                    list.get(k);
                }
            }
        }
    };
    //执行插入的匿名类
    static Test insertTest = new Test("insert") {
        @Override
        public void test(List<Double> list) {
            ListIterator<Double> it = list.listIterator(list.size() / 2);
            for (int i = 0; i < SIZE; i++) {
                it.add(1.0);
            }
        }
    };
    //执行删除的匿名类
    static Test removeTest = new Test("remove") {
        @Override
        public void test(List<Double> list) {
            ListIterator<Double> it = list.listIterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    };

    static public void testArray(List<Double> list) {
        Test[] tests = {iterateTest, getTest};
        test(tests, list);
    }

    static public void testList(List<Double> list) {
        Test[] tests = {insertTest, iterateTest, getTest, removeTest};
        test(tests, list);
    }

    static public void test(Test[] tests, List<Double> list) {
        for (int i = 0; i < tests.length; i++) {
            System.out.print(tests[i].getOperation() + "操作：");
            long t1 = System.currentTimeMillis();
            tests[i].test(list);
            long t2 = System.currentTimeMillis();
            System.out.print(t2 - t1 + "ms");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        List<Double> list = null;
        //测试数组的迭代和随机访问操作
        System.out.println("------测试数组------");
        Double[] tstr = new Double[SIZE];
        Arrays.fill(tstr, Math.random());
        list = Arrays.asList(tstr);
        testArray(list);

        tstr = new Double[SIZE];
        Collection<Double> coll = Arrays.asList(tstr);

        //测试Vector
//        System.out.println("------测试Vector------");
//        list = new Vector<>();
//        list.addAll(coll);
//        testList(list);
        //测试LinkedList
        System.out.println("------测试LinkedList------");
        list = new LinkedList<>();
        list.addAll(coll);
        testList(list);

        //测试ArrayList
        System.out.println("------测试ArrayList------");
        list = new ArrayList<>();
        list.addAll(coll);
        testList(list);
    }
}
