/**
 * Created by leesen on 2019/10/31.
 */
public class LeetCode_153_338 {
    //条件的梳理简化很重要，连空和单元素特殊情形都包含了
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //[1,2,3,4,5]
            //[2,3,4,5,1]
            //[5,1,2,3,4]
            //先判断右侧，且=mid而不是mid-1，涵盖了特殊情形，避免了边界溢出
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}
