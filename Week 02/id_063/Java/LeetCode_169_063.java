/*
思路

众数x是数量超过了总数一半的数字，那么如果把序列以任意比例切成两半，那么x至少是两部分子
序列其中一个序列的众数，这个可以进行反证，如果x在两个子序列中数量都没有超过一半，两个子序列
并在一起，x总数怎么可能超过总数一半呢？

所以子序列中的众数是全序列众数的候选者，两个子序列至少一个序列有众数，否则不可能全序列有众数（题目说了输入数据保证全局有众数）
如果只有一个候选者，那最终众数必然就是这个候选者
如果两个子序列都产生了候选者，需要统计两个候选者在总序列中的频数，必然有一个胜出者

基于以上的逻辑进行分治查找
可以用ForkJoin线程池实现多线程的分治
*/


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class ComputeTask extends RecursiveTask<Integer> {
    private int[] nums;
    private int start;
    private int end;

    // 判断是否是众数
    private boolean isMajorElement(int[] nums, int start, int end, int num) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                cnt++;
            }
        }

        return (cnt > (end - start + 1) / 2);
    }


    public ComputeTask(int[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end == start) {
            return nums[end];
        }

        ComputeTask tLeft = new ComputeTask(nums, start, start + ((end-start)/2));
        ComputeTask tRight = new ComputeTask(nums, start+(end-start)/2 + 1, end);
        invokeAll(tLeft, tRight);

        Integer leftRet = tLeft.join();
        Integer rightRet = tRight.join();
        Integer major = null;

        if ((leftRet != null) && isMajorElement(nums, start, end, leftRet)) {
            major = leftRet;
        }

        if ((rightRet != null) && isMajorElement(nums, start, end, rightRet)) {
            major = rightRet;
        }

        return major;
    }
}


class Solution {
    public int majorityElement(int[] nums) {
        RecursiveTask<Integer> task = new ComputeTask(nums, 0, nums.length-1);
        ForkJoinPool.commonPool().execute(task);
        return task.join();
    }
}