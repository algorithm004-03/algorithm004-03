package com.weekwork;

/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */


class RotatedArray {

    //Method 1 Explain：计算需要移动的位置，在开始移动点切割数组，将切割后需要旋转的的部分与剩余部分换位拼合
    public void rotateFuncOne(int[] nums, int k) {
        int length = nums.length;
        int newk = k % length;
        int[] newArray = new int[length];
        System.arraycopy(nums,nums.length-newk,newArray,0,newk);
        System.arraycopy(nums,0,newArray,newk,nums.length-newk);
        System.arraycopy(newArray,0,nums,0,length);
    }

    //Method 2 Explain:计算当前数组在最终移动后各节点需要移动的具体位置，并将计算好位置的元素按照新位置插入新的数组中
    public void rotateFuncTwo(int[] nums, int k) {
        int length = nums.length;
        int newk = k % length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            int newPosition = (i + newk) % length;
            newArray[newPosition] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, length);
    }
}


