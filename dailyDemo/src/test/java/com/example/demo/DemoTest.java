package com.example.demo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Test
 *
 * @author wangjiangtao
 * @date 2018/04/27
 **/
public class DemoTest {

    /**
     * 1. 初始化线程池,容量8,并发队列长度8,任务计数器内容8
     *
     * 2. 初始化加入模数队列
     *
     */
    @Test
    public void test() {
        // 初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        // 新建并发任务队列
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue(8);
        // 剩余未完成任务计数器
        final CountDownLatch countDownLatch = new CountDownLatch(8);
        // 初始化模数队列
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
        }
        // 死循环,退出条件是任务计数器为0
        for (;;) {
            // 如果队列不为空代表有未完成任务,新建线程
            while (!queue.isEmpty()) {
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "===》开始了");

                    Integer mod = 0;
                    try {
                        mod = queue.take();
                        System.out.println(Thread.currentThread().getName() + "取出元素:" + mod);
                        while (true) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "mod" + mod + "放回");
                        queue.add(mod);
                    }
                });
            }
            if (countDownLatch.getCount() == 0) break;
        }
    }
}
