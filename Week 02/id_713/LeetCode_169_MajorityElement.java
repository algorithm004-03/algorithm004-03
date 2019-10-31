package id_713;

/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class LeetCode_169_MajorityElement {


    public int majorityElement(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int low, int high) {
        if (low == high) return nums[low]; // 当且仅当 数组元素个数为1时, 返回这1个元素, 就是众数

        // 递归, 分治左右两个切片
        int mid = (high - low) / 2 + low;
        int left = divideConquer(nums, low, mid);
        int right = divideConquer(nums, mid + 1, high);

        // 如果两个半边都统一, 则返回众数
        if (left == right) return left;

        // 否则重新唱票, 决出众数
        int leftCnt = countInRange(nums, left, low, high);
        int rightCnt = countInRange(nums, right, low, high);

        // 看谁票数多
        return leftCnt > rightCnt ? leftCnt : rightCnt;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                cnt++;
            }
        }
        return cnt;
    }

}
