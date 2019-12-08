package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolutionIsAnagram242 {


    @Test
    public void test1() {
        System.out.println(isAnagram_20191024_1("anagram", "nagaram"));
        System.out.println(isAnagram_20191024_2("anagram", "nagaram"));
        System.out.println(isAnagram_20191024_3("anagram", "nagaram"));
    }


    /**
     * 1. 排序 O(Nklogk) O(K)
     * 2. int[] O(NK) O(N)
     * 3. map O(NK) O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_20191024_1(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram_20191024_2(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (Character c : s.toCharArray()) {
            table[c - 'a'] ++;
        }
        for (Character c : t.toCharArray()) {
            table[c - 'a'] --;
            if (table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram_20191024_3(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        for (Character c: t.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == 0) {
                return false;
            } else {
                map.put(c, cnt - 1);
            }
        }
        return true;
    }

    /**
     * 1.排序
     * 2.map 为什么使用map这么慢
     * 3.数组
     *
     * map int【】 本质是一样的
     * 第一个循环计数 第二个循环减数 如果小于0 return false  第三个循环判断是否大于0
     *
     * 1.审题 2.思考所有的思路 3.code 4.testCase
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_sort(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }


    /**
     * 要确认大小字母是够一样对待
     * 第二个循环做判断，提早结束
     * best
     * 数组
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_arr(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counter[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            int index = t.charAt(i) - 'a';
            counter[index] --;
            if (counter[index] < 0) {
                return false;
            }
        }
        for (int count : counter) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    // 更加通用
    public boolean isAnagram_map_better(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            sMap.put(sc, sMap.get(sc) == null ? 1 : sMap.get(sc) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character tc = t.charAt(i);
            Integer count = sMap.get(tc);
            if (count == null || count == 0) {
                return false;
            }
            sMap.put(tc, count - 1);
        }
        return true;
    }


}
