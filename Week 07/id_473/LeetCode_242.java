package LeetCode;

import java.util.Arrays;

/**
 * 242.有效的字母异位词
 *
 * @author CJ
 * @date 2019年12月02日 2:21
 */
public class LeetCode_242 {
    public static void main(String[] args) {
        String s = "anagram",t ="nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        //将两个字符数组进行排序后通过equals函数进行比较
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
