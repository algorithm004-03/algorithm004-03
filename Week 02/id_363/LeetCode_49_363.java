package com.test.leetcode.week02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class SolutionGroupAnagrams49 {


    @Test
    public void test1() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }


    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * ["eat", "tea", "tan", "ate", "nat", "bat"],
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 排序： O(NMlogM) N是数组长度 M是数组内字符串的平均长度 空间复杂度O(N)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null  || strs.length == 0) return null;
        Map<String, List<String>> result = new HashMap<>(strs.length);
        for(String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String orderStr = new String(charArr);
            List<String> charList = result.get(orderStr);
            if ( charList == null) {
                charList = new LinkedList<>();
                result.put(orderStr, charList);
            }
            charList.add(str);
        }
        return new ArrayList<>(result.values());
    }

    // 生成特殊字符 时间复杂度：O(NM) 空间复杂度 O(N)
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null  || strs.length == 0) return null;
        Map<String, List<String>> result = new HashMap<>(strs.length);
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (Character c : str.toCharArray()) {
                count[c - 'a'] ++;
            }
            StringBuffer keyBuf = new StringBuffer();
            for (int j = 0; j < count.length; j ++) {
                keyBuf.append("#" + count[j]);
            }
            List<String> keyList = result.get(keyBuf.toString());
            if (keyList == null) {
                keyList = new LinkedList<>();
                result.put(keyBuf.toString(), keyList);
            }
            keyList.add(str);
        }
        return new ArrayList<>(result.values());
    }

    /**
     * 算术基本定理(正整数唯一分解定理)：每一个大于1的自然数，要么本身是质数，
     * 要么可以写成两个以上质数的积，而且这些质因子按大小排列好之后，写法仅有一种方式
     * 缺陷： key 是累计相乘，可能会导致int溢出
     * 时间复杂度：O(NM) 空间复杂度 O(N)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null  || strs.length == 0) return null;
        Map<Integer, List<String>> result = new HashMap<>(strs.length);
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (String str : strs) {
            Integer key = 1;
            for (Character c: str.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> keyList = result.get(key);
            if (keyList == null) {
                keyList = new ArrayList<>();
                result.put(key, keyList);
            }
            keyList.add(str);
        }
        return new ArrayList<>(result.values());
    }
}
