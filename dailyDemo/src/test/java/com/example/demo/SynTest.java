package com.example.demo;

import org.junit.Test;

/**
 * synchronized关键字练习
 *
 * @author wangjiangtao
 * @date 2018/05/04
 **/
public class SynTest {

    @Test
    public void test(){

        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    InsertClass.insertInto(Thread.currentThread());
                }
            }.start();
        }

        InsertClass oj = new InsertClass();
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    oj.insertInto2(Thread.currentThread());
                }
            }.start();
        }

    }

    static class InsertClass{

        private String name;

        /**
         * 类锁
         *
         * @param thread
         */
        static void insertInto(Thread thread){
            synchronized(InsertClass.class){
                for (int i = 0; i < 5; i++) {
                    System.out.println(thread.getName()+"正在插入" + i);
                }
            }
        }

        /**
         * 对象锁
         *
         * @param thread
         */
        void insertInto2(Thread thread){
            synchronized(this){
                for (int i = 0; i < 5; i++) {
                    System.out.println(thread.getName()+"正在插入" + i);
                }
            }
        }

    }
}
