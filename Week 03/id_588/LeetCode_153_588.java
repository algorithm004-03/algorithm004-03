/**
 * 寻找旋转数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class LeetCode_153_588 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode_33_588_BK solution = new LeetCode_33_588_BK();

        int ret3 = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        int ret4 = solution.findMin(new int[]{8, 9, 0, 1, 4, 7});
        int ret5 = solution.findMin(new int[]{0, 1, 2, 3, 4, 5, 6});
        int ret6 = solution.findMin(new int[]{2, 3, 4, 5, 6, 7, 0});
        System.out.println(ret3);
        System.out.println(ret4);
        System.out.println(ret5);
        System.out.println(ret6);
    }

}
