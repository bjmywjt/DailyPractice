package com.example.demo;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字练习
 *
 * @author wangjiangtao
 * @date 2018/05/09
 **/
public class VolatileTest {

    final int a = 0;
    volatile int b = 0;
    AtomicInteger ai = new AtomicInteger(0);

    private void increaseA(){
//        a++;
    }

    private void increaseAtomicA(){
        ai.getAndIncrement();
    }

    private synchronized void increaseSynB(){
        b++;
    }


    @Test
    public void test(){
        final VolatileTest vt = new VolatileTest();
        for (int i = 0; i < 10; i++)
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        vt.increaseA();
                        vt.increaseAtomicA();
                        vt.increaseSynB();// 同步保证原子性

                    }
                }
            }.start();

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(vt.a);// 非同步 不能保证原子性
        System.out.println(vt.b);// 同步 保证原子性
        System.out.println(vt.ai.get());// 原子Integer
    }

}
