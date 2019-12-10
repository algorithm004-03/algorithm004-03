package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1122.数组的相对排序
 *
 * @author CJ
 * @date 2019年12月01日 19:18
 */
public class LeetCode_1122 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] ints = relativeSortArray(arr1, arr2);
        for (int i:
             ints) {
            System.out.println(i);
        }
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];

        int[] result = new int[arr1.length];
        //在m数组中给对应的数字位置计数，
        for(int i = 0; i < arr1.length; i++) {
            map[arr1[i]]++;
        }

        int cnt = 0;//创建从0开始从左到右的指针，用来进行指定赋值
        for(int i = 0; i < arr2.length; i++) {
            while(map[arr2[i]] > 0) {
                result[cnt++] = arr2[i];
                map[arr2[i]]--;
            }
        }
        //将剩余的值按顺序放到result后面
        for(int i = 0; i < 1001; i++) {
            while(map[i] > 0) {
                result[cnt++] = i;
                map[i]--;
            }
        }
        return result;
    }
}
