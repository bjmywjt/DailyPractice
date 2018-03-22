package com.daily.thread;

import java.util.Timer;

/**
 * 中断线程
 *
 * @author wangjiangtao
 * @date 2018/03/08
 **/
public class InterruptedThread implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){

            System.out.println(123);
        }
        System.out.println(Thread.currentThread().isInterrupted());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(456);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptedThread(), "interrupted");
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(thread.getName()+ "'s interrupted is " + thread.isInterrupted());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(678);
    }
}
