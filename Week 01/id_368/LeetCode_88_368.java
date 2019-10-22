import java.util.Arrays;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_88_368 {

    /*给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    链接：https://leetcode-cn.com/problems/merge-sorted-array*/

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(i -> System.out.print(i + " "));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 采用双指针的形式，因为数组本身有序，所以从后往前遍历操作，直接将合适的数据放到该位置即可
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        // nums2数组未遍历完需要单独处理
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
