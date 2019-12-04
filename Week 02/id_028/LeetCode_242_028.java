package com.jane.part242;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
            if (chars[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        Assert.assertEquals(isAnagram(s, t), true);
    }

    @Test
    public void test1() {
        String s = "rat", t = "car";
        Assert.assertEquals(isAnagram(s, t), false);
    }

    @Test
    public void test2() {
        String s = "", t = "";
        Assert.assertEquals(isAnagram(s, t), true);
    }

    @Test
    public void test3() {
        String s = "aacc", t = "ccac";
        Assert.assertEquals(isAnagram(s, t), false);
    }

    @Test
    public void test4() {
        String s = "aaccssssssssssssssssssssssssssssssssssssssssssssssssssssss", t = "ccaccssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        Assert.assertEquals(isAnagram(s, t), false);
    }
}
