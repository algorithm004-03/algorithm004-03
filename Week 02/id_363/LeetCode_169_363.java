package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SolutionMajorityElement169 {


    @Test
    public void test1() {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{3,2,3}));

        System.out.println(majorityElement2(new int[]{1}));
        System.out.println(majorityElement2(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement2(new int[]{3,2,3}));
        System.out.println("------------");
        System.out.println(majorityElement2Better(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement2Better(new int[]{3,2,3}));

        System.out.println("------------");
        System.out.println(majorityElement3DivideAndConquer(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement3DivideAndConquer(new int[]{3,2,3}));


        System.out.println("------------");
        System.out.println(majorityElementBM(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElementBM(new int[]{3,2,3}));
    }

    /**
     * 1. map 统计数量 时间复杂度是O(n)
     * 2. 排序 记录每个元素的count 时间复杂度是O(nlogn)
     * 3. 分治
     * 4.Booyer-More 算法  候选人
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i ++) {
            Integer count = map.get(nums[i]);
            map.put(nums[i], count == null ? 1 : count + 1);
            if (map.get(nums[i]) > len / 2) {
                return nums[i];
            }
        }
        return nums[0];
    }


    public int majorityElement2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < len; i ++) {
            if (nums[i] == nums[i - 1]) {
                count ++;
            } else {
                count = 1;
            }
            if (count > len / 2) {
                return nums[i];
            }
        }
        return nums[0];
    }


    /**
     * 数据排序后，众数因为占数据的一般以上，所以下标在len / 2位置的数字一定是众数
     * 如果众数是数组的最小值或者最大值，当数组数量是奇数/偶数，那么n/2 一定会覆盖到
     * @param nums
     * @return
     */
    public int majorityElement2Better(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int majorityElement3DivideAndConquer(int[] nums) {
        return majorityDC(nums, 0, nums.length - 1);
    }

    // [start, end)
    private int majorityDC(int[] nums, int start, int end) {
        // 终止条件
        if ( start == end) {
            return nums[start];
        }
        // 解决当前层
        // 下探到下一层
        int mid = (start + end) / 2;
        int left = majorityDC(nums, start, mid);
        int right = majorityDC(nums, mid + 1, end);
        // 合并子问题
        if (left == right) {
            return left;
        }
        int leftCount = countNums(nums, left, start, mid);
        int rightCount = countNums(nums, right, mid + 1, end);
        return leftCount > rightCount ? left : right;
        // 清理当前层

    }

    private int countNums(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i ++) {
            if (nums[i] == num) {
                count ++;
            }
        }
        return  count;
    }


    /**
     * Booyer-More 算法
     * 其他数字出现次数的总和不会超过这个数字出现的次数
     * 替换 candidate 的时候，如果这个candidate 是众数，那么去掉了相同数量的众数和其他数字
     * 剩余的数组中，众数的数量还是大于其他数量的综合
     *
     * 如果替换的candidate 不是众数，那么去掉这个数，去掉了x的众数和大于x的非众数
     * 剩下的数组中，众数的数量还是大于其他数量的综合
     *
     * @param nums
     * @return
     */
    public int majorityElementBM(int[] nums) {
        int count = 0;
        Integer condidate = null;
        for (int i = 0; i < nums.length; i ++) {
            if (count == 0) {
                condidate = nums[i];
            }
            count += (nums[i] == condidate ? 1 : -1);
        }
        return condidate;
    }

}
