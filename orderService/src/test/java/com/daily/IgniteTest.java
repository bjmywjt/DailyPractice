package com.daily;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.Ignition;
import org.junit.Test;

/**
 * IgniteTest
 *
 * @author wangjiangtao
 * @date 2018/03/14
 **/
public class IgniteTest {

    @Test
    public void test(){
        Ignite ignite = Ignition.start();
        IgniteAtomicSequence seq = ignite.atomicSequence("seqName",//序列名
                0, //初始值
                true//如果序列不存在则创建
        );
        for (int i = 0; i < 20; i++) {
            long currentValue = seq.get();//获取当前值
            long newValue = seq.incrementAndGet();//先加1再取值
            System.out.println("currentValue:" + currentValue);
            System.out.println("newValue:" + newValue);
        }
    }

    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        IgniteAtomicSequence seq = ignite.atomicSequence("seqName",//序列名
                0, //初始值
                true//如果序列不存在则创建
        );
        for (int i = 0; i < 20; i++) {
            long currentValue = seq.get();//获取当前值
            long newValue = seq.incrementAndGet();//先加1再取值
            System.out.println("currentValue:" + currentValue);
            System.out.println("newValue:" + newValue);
        }
    }
}
