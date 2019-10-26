/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26_588 {

    /**
     * 快慢指针法
     */
    public int removeDuplicates(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < a.length; j ++) {
            if (a[i] != a[j]) {
                i ++;
                a[i] = a[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        LeetCode_26_588 solution = new LeetCode_26_588();
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 2, 3, 3, 3, 4, 5, 5, 6}));
        System.out.println(solution.removeDuplicates(new int[0]));
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 1}));
    }
}
