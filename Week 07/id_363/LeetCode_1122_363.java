package com.test.leetcode.week07;

import org.junit.Test;

import java.util.Arrays;


public class SolutionRelativeSort1122 {


    @Test
    public void test1() {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
    }

    // 计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int a1 : arr1) {
            cnt[a1] ++;
        }
        int[] res = new int[arr1.length];
        int k = 0;
        for (int a2 : arr2) {
            while (cnt[a2] -- > 0) {
                res[k ++] = a2;
            }
        }
        for (int i = 0; i < 1001; i ++) {
            if (k == arr1.length) {
                break;
            }
            while(cnt[i] > 0) {
                res[k ++] = i;
                cnt[i] --;
            }
        }
        return res;
    }

}
