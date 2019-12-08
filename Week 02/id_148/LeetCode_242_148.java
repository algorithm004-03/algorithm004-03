package com.ning.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @author shaoyu
 * @create 2019-10-24 下午6:32
 */
public class LeetCode_242_148 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if(s == null) {
            return false;
        }

        if(t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] arrS = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(map.get(arrS[i]) == null) {
                map.put(arrS[i],  1);
            } else {
                map.put(arrS[i], map.get(arrS[i]) + 1);
            }
        }

        char[] arrT = t.toCharArray();
        for(int i = 0; i < t.length(); i++) {
            if(map.get(arrT[i]) == null) {
                return false;
            } else if(map.get(arrT[i]) == 1) {
                map.remove(arrT[i]);
            } else {
                map.put(arrT[i], map.get(arrT[i]) - 1);
            }
        }

        if(map.isEmpty()) {
            return true;
        }

        return false;
    }

    @Test
    public void test() {
        System.out.println(isAnagram("anagram", "Aagaram"));
    }
}
