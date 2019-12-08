package id_338;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram
 */
public class LeetCode_242_338 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "bca";
        boolean result1 = isAnagram1(s, t);
        boolean result2 = isAnagram2(s, t);
    }

    //方法1: 利用数据排序, O(nlogn), Arrays.sort底层双基快排算法
    //要注意Arrays.sort(), Arrays.equals()的写法
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    //方法2: 利用哈希表, O(n)。 也可以先将s放入哈希表,再遍历t,小于0就返回false
    //要注意s.charAt(i)的写法
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
