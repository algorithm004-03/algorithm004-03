package com.github.kylefeng;

/**
 * @author kylefeng
 * @time 2019/12/1 15:35
 */
public class LeetCode_1122_038 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;

        for (int i : arr1) {
            bucket[i]++;
        }

        for (int i : arr2) {
            while (bucket[i]-- > 0) {
                result[index++] = i;
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (bucket[i] > 0) {
                while (bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }
}
