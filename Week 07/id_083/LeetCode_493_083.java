import java.util.Arrays;

/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {

    //O（nlogn*logn）
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if(start>=end)	return 0;
        int mid = start + (end-start)/2;

        //左右进行归并排序
        int cnt = mergeSort(nums, start, mid)+mergeSort(nums, mid+1, end);

        for(int i = start,j=mid+1;i<=mid;i++){
            //统计重要反转对的个数
            while(j<=end && nums[i]/2.0 > nums[j])
                j++;
            cnt += j - (mid+1);
        }

        //最后归并
        Arrays.sort(nums,start,end+1);
        return cnt;
	}

}
// @lc code=end

