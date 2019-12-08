package com.test.leetcode.week02;

import org.junit.Test;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionIsAnagram242 {


    @Test
    public void test1() {

        System.out.println(isAnagram_20191201_1("anagram", "nagaram"));
        System.out.println(isAnagram_20191201_2("anagram", "nagaram"));
        System.out.println(isAnagram_20191201_3("anagram", "nagaram"));
    }

    /**
     * 1.排序
     * 2.int[] 计数
     * 3.map计数
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_20191201_1(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }

    public boolean isAnagram_20191201_2(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (char sc : s.toCharArray()) {
            cnt[sc - 'a'] ++;
        }
        for (char tc : t.toCharArray()) {
            cnt[tc - 'a']--;
            if (cnt[tc - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram_20191201_3(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> cnt = new HashMap<>();
        for (char sc : s.toCharArray()) {
            cnt.put(sc, cnt.get(sc) == null ? 1 : cnt.get(sc) + 1);
        }

        for (char tc : t.toCharArray()) {
            Integer num = cnt.get(tc);
            if (num == null || num == 0) {
                return false;
            }
            cnt.put(tc, num - 1);
        }
        return true;
    }



}
