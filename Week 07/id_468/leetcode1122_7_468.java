package week7;

/**
 * @program: leetcode
 * @description: 1122. Relative Sort Array
 * @author: 王瑞全
 * @create: 2019-12-0122:26
 **/


public class leetcode1122_7_468 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //count frequency
        int[] f = new int[1001];
        for (int i : arr1) f[i]++;

        //arrange arr1 based on arr2
        int index = 0;
        for (int i : arr2) {
            while(f[i] > 0) {
                arr1[index++] = i;
                f[i]--;
            }
        }

        //sort the rest of the numbers not in arr2
        for (int i = 0; i < 1001; i++){
            while(f[i] > 0) {
                arr1[index++] = i;
                f[i]--;
            }
        }
        return arr1;
    }
}
