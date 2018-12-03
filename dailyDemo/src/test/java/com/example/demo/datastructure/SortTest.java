package com.example.demo.datastructure;

import com.example.demo.datastructure.Sort.BubbleSort;
import org.junit.Test;

/**
 * 排序TEST
 *
 * @author wangjiangtao
 * @date 2018/07/18
 **/

public class SortTest {

    @Test
    public void bubbleSortTest(){
        int[] ints = {1,70,33,7,2,16,100};
        BubbleSort bubbleSort = new BubbleSort(ints);
        bubbleSort.show();
        bubbleSort.sort();
        bubbleSort.show();
    }
}
