/*
 * @lc app=leetcode id=153 lang=csharp
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
public class Solution
{
    public int FindMin(int[] nums)
    {
        if (nums.Length <= 0) return -1;
        if (nums.Length == 1) return nums[0];
        return nums[FindPivotIndex(nums)];
    }

    private int FindPivotIndex(int[] nums)
    {
        int start = 0;
        int end = nums.Length - 1;
        if (nums[start] < nums[end]) return 0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid + 1] <= nums[mid])
            {
                return mid + 1;
            }
            else if (nums[mid] < nums[start])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return 0;
    }
}
// @lc code=end

