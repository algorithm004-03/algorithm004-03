import java.util.Arrays;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class LeetCode_66_588 {

    public int[] plusOne(int[] a) {
        int i = a.length - 1;
        while (i >= 0 && 9 == a[i]) {
            a[i] = 0;
            i --;
            if(i < 0) {
                a = new int[a.length + 1];
                i = 0;
            }
        }
        a[i] = a[i] + 1;
        return a;
    }

    public static void main(String[] args) {
        LeetCode_66_588 solution = new LeetCode_66_588();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
    }
}
