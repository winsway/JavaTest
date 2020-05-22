/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.testParallelStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * java 8 有一个新的特性就是流，其中stream和parallelStream就是一种流的处理方式，
 * 前者是单管，后者是多管道，在性能上做一个对比看看两者的差别。</p>
 *
 * @see https://blog.csdn.net/xiaoliuliu2050/article/details/85999008
 * @author winsway
 */
public class TestStream {

    public static List<Integer> buildIntRange() {
        List<Integer> numbers = new ArrayList<>(5);
        for (int i = 0; i < 60000; i++) {
            numbers.add(i);
        }
        return Collections.unmodifiableList(numbers);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> source = buildIntRange();
        // 传统方式的遍历
        long start = System.currentTimeMillis();
        for (int i = 0; i < source.size(); i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("传统方式 : " + (System.currentTimeMillis() - start) + "ms");
        // 单管道stream
        start = System.currentTimeMillis();
        source.stream().forEach(r -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("stream : " + (System.currentTimeMillis() - start) + "ms");
        // 多管道parallelStream
        start = System.currentTimeMillis();
        source.parallelStream().forEach(r -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("parallelStream : " + (System.currentTimeMillis() - start) + "ms");
    }

}
