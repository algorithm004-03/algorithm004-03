package id_693;

import java.util.Arrays;

/**
 * @Desc 242. 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_242_693 {
    //暴力破解
    public boolean isAnagram(String s, String t) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        char [] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
    public int[] plusOne(int[] digits) {
        boolean is = true;
        for (int i =  digits.length - 1; i >= 0;i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_242_693().plusOne(new int[]{2,9,9,9,9})));




        System.out.println(new LeetCode_242_693().isAnagram("asd", "asd"));
        System.out.println(new LeetCode_242_693().isAnagram("asde", "saed"));
        System.out.println(new LeetCode_242_693().isAnagram("anagram", "nagaram"));
    }
}
