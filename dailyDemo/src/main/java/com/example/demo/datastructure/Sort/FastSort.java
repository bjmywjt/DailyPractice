package com.example.demo.datastructure.Sort;

import com.example.demo.datastructure.Sort.Interface.Sort;

/**
 * @author wangjiangtao
 * @date 2018/07/17
 **/
public class FastSort implements Sort{

    private int[] ints = null;

    private FastSort(){}

    public FastSort(int[] ints) {
        this.ints = ints;
    }

    @Override
    public void sort() {
        quick_sort(ints, 0, ints.length-1);
    }

    @Override
    public void show() {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + (i == ints.length - 1 ? "":","));
        }
        System.out.println();
    }


    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

}
