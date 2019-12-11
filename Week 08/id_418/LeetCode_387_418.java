package com.ljg.leetcode.week08.a04;

/**
 * FirstUniqueCharacterInAString
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        // String s = "leetcode";
        String s = "loveleetcode";
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        int index =f.firstUniqChar(s);
        System.out.println("index=" + index);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.trim().length() == 0) {
            return -1;
        }
        int[] arrs = new int[26];
        int len = s.length();
        char[] chs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            arrs[chs[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (arrs[chs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}