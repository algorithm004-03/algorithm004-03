import java.util.Arrays;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class LeetCode_189_588 {

    /**
     * 反转法
     */
    public void rotate(int[] a, int k) {
        int m = k % a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, m - 1);
        reverse(a, m, a.length - 1);
    }

    public void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        LeetCode_189_588 solution = new LeetCode_189_588();
        int[] test = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        solution.rotate(test, 3);
        System.out.println(Arrays.toString(test));

        int[] test2 = new int[]{0, 1, 2, 3};
        solution.rotate(test2, 10);
        System.out.println(Arrays.toString(test2));
    }
}
