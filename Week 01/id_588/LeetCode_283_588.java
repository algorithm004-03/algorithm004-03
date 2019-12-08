import java.util.Arrays;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode_283_588 {

    public void move(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i ++) {
            if (0 != a[i]) {
                a[j] = a[i];
                if (i != j) {
                    a[i] = 0;
                }
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {0, 4, 3, 0, 9, 10, 5, 4, 0, 8};
        LeetCode_283_588 solution = new LeetCode_283_588();
        solution.move(test);
        System.out.println(Arrays.toString(test));
    }
}
