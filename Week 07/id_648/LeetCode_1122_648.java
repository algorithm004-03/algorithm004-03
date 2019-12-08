import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * @Date 2019/12/1
 **/
public class LeetCode_1122_648 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxNum = 0;
        for(int i=0;i<arr1.length;i++){
            maxNum=Math.max(maxNum,arr1[i]);
        }
        int[] bucket = new int[maxNum+1];
        List<Integer> result = new ArrayList();
        for(int i=0;i<arr1.length;i++){
            bucket[arr1[i]]++;
        }
        for(int i=0;i<arr2.length;i++){
            while(bucket[arr2[i]]>0){
                result.add(arr2[i]);
                bucket[arr2[i]]--;
            }
        }
        for(int i=0;i<=maxNum;i++){
            while(bucket[i]>0){
                result.add(i);
                bucket[i]--;
            }
        }
        int[] s = new int[arr1.length];
        for(int i=0;i<result.size();i++){
            s[i]=result.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode_1122_648 leetCode_1122_648 = new LeetCode_1122_648();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 =new int[]{2,1,4,3,9,6};
        int[] arr3 = leetCode_1122_648.relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(arr3));

    }
}
