/**
 * Created by leesen on 2019/10/31.
 */
public class LeetCode_33_338 {
    //硬上二叉搜索, 只是夹逼判断条件变换一下, O(log
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;  //****增加等值输出, 减少下面判断复杂度
            //左边单调,比最大的还大,继续往右找
            //****nums[left] <= nums[mid], 此处必须有=号
            // 否则当left和mid值相等又都不等于target的时候right = mid - 1可能正好跳过了值
            if (nums[left] <= nums[mid] && (target > nums[mid] || target < nums[left])) left = mid + 1;
            else if (target < nums[left] && target > nums[mid]) left = mid + 1; //左边非单调, 但是比左边小,比mid大,继续往右找
            else right = mid - 1;
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
