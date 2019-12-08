package id_338;

/**
 * Created by leesen on 2019/10/30.
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

    //相关子问题练习, 寻找旋转数组中的旋转位置下标
    private static int getReverseIndex(int[] a) {
        if (a.length == 0 || a.length == 1) return a.length;
        if (a.length == 2) return 1;  //防止下面每次都判断边界溢出
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) return mid;
            else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
