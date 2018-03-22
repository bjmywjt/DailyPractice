package com.daily.DSAA;

/**
 * 递归类
 *
 * @author wangjiangtao
 * @date 2018/02/27
 **/
public class RecursiveDemo {

    public static void printOut(int n){
        if (n >= 10)
            printOut(n/10);
        System.out.println(n%10);
    }

    public static void main(String[] args) {
        printOut(54321);
    }
}
