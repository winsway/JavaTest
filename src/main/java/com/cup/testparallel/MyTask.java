/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cup.testparallel;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * <pre>CountDownLatch</pre>
 * <pre>ExecutorService</pre>
 * <pre>Future
 * <br /> <br />Callable</pre>
 * <pre><span style="font-size: 16px;">实现并行编程，并在并行线程同步时，用起来十分简单的一种 。
 * <br />实现原理：<br /></span></pre>
 * <pre>1、CountDownLatch 统计并行线程完成数，并提供了await()方法，实现等待所有并行线程完成，或者指定最大等待时间。
 * <br />2、ExecutorService提供了execute(Callable)执行线程方法，还提供了submit（Callable）提交线程。
 * <br />3、Future接受实现Callable&lt;V&gt;接口的（可执行线程）返回值，接受Executors.submit(Callable&lt;V&gt;)返回值。
 * 而且Future&lt;V&gt;提供get()取回并行子线程返回的参数，还可以给get指定过期时间。
 * <br />
 * <br />
 * </pre>
 *
 * @see https://www.cnblogs.com/yy3b2007com/p/5827662.html
 * @author winsway
 */
public class MyTask implements Callable<MyTaskResult> {

    private final TaskItem taskItem;
    private final CountDownLatch threadsSignal;

    public MyTask(CountDownLatch threadsSignal, TaskItem taskItem) {
        this.threadsSignal = threadsSignal;
        this.taskItem = taskItem;
    }

    @Override
    public MyTaskResult call() throws Exception {
        MyTaskResult result = new MyTaskResult(this.taskItem.getName());

        // 核心处理逻辑处理
        Thread.sleep(2000);

        System.out.println("task id:" + taskItem.getId() + " >>>>等待結束");
        System.out.println("task id:" + taskItem.getId()
                + " >>>>线程名称:" + Thread.currentThread().getName()
                + "结束. 还有" + threadsSignal.getCount() + " 个线程");

        // 必须等核心处理逻辑处理完成后才可以减1
        this.threadsSignal.countDown();

        return result;
    }

}
