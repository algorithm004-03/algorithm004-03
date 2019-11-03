package org.geektime.weak01;

/**
 * Created by fukan on 2019/10/22.
 */


public class LeetCode_283_178 {
    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        LeetCode_283_178 instance =  new LeetCode_283_178();
        //instance.solution1(nums);
        //instance.solution2(nums);
        //instance.solution3(nums);
        instance.solution4(nums);
    }

    /**
     解法一:双指针解法
     1、维护一个总是指向0的动态指针 i
     2、每次遇到非0位置的数将其位置的数与0位置指针索引上的数进行交换值并更新1的指针i++
     两处交换 一处总为0 所以直接赋值为0 不用存储临时变量 但如此就需要判断 i 是否等于 j 去掉为自己的情况
     */
    public static int[] solution1(int[] nums){
        int index = 0;
        for (int i = 0 ;i < nums.length;i++){
            if(nums[i] != 0){
                if(index != i){
                    nums[index] = nums[i];
                nums[i] = 0;
                }
                index++;
            }

        }
        return nums;
    }

    /**
     * 遍历取非0值 && push 0
     * @param nums
     * @return
     */
    public static int[] solution2(int[] nums){
        int insertZero = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if (nums[i] != 0){
                nums[insertZero++] = nums[i];
            }
        }
        while(insertZero < n){
            nums[insertZero++] = 0;
        }
        return nums;
    }

    /**
     * 维护一个计数变量count
     */
    public static int[] solution3(int[] nums){
        int count = 0;
        for (int i = 0; i< nums.length ;i++){
            if (nums[i] == 0) {
                count++;
            }else{
                nums[i-count] = nums[i];
            }
        }

        for (int i = nums.length - count;i<nums.length;i++){
            nums[i]=0;
        }

        return nums;
    }

    /**
     * 设置一个Cache,进行交换
     */
    public static int[] solution4(int[] nums){
        int j =0;

        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i]=temp;
                j++;
            }
        }

        return nums;
    }
}

