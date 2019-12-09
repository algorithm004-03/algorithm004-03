package test1;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/10/20.
 */
public class Leetcode_189_638 {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(k == 0){//移动次数长度整数倍，不需要处理
            return;
        }
        for(int i=0;i<k;i++){
            int last = nums[len-1];
            System.arraycopy(nums,0,nums,1,len-1);
            nums[0] = last;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);
        for(int a :arr){
            System.out.print(a+",");
        }
    }
}
