package com.example.demo.datastructure.Sort;

import com.example.demo.datastructure.Sort.Interface.Sort;

/**
 * 冒泡排序
 *
 * @author wangjiangtao
 * @date 2018/07/18
 **/
public class BubbleSort implements Sort {

    private int[] ints = null;

    private BubbleSort() {
    }

    public BubbleSort(int[] ints) {
        this.ints = ints;
    }

    @Override
    public void sort() {
        if (ints.length == 0 || ints.length == 1) return;
        for (int i = 0; i < ints.length-1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] < ints[j+1]){
                    int tmp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = tmp;
                }
            }
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + (i == ints.length - 1 ? "":","));
        }
        System.out.println();
    }
}
