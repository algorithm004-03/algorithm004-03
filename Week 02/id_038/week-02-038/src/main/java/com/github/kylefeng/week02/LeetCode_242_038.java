package com.github.kylefeng.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 242. 有效的字母异位词
 *
 * @author kylefeng
 * @time 2019/10/26 10:32
 */
public class LeetCode_242_038 {


    /**
     * 判断两个字符串是否为两个有效的字母异位词。
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return boolean
     */
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.equals("") || str2.equals("")) {
            return true;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Map<Integer, Integer> hash1 = makeHash(chars1);
        Map<Integer, Integer> hash2 = makeHash(chars2);

        for (Map.Entry<Integer, Integer> entry : hash1.entrySet()) {
            Integer key = entry.getKey();
            if (!Objects.equals(hash1.get(key), (hash2.get(key)))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Integer> makeHash(char[] chars) {
        Map<Integer, Integer> hash = new HashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            Integer key = (int) chars[i];
            Integer counter = hash.get(key);
            if (counter == null) {
                hash.put(key, 1);
            } else {
                hash.put(key, counter + 1);
            }
        }
        return hash;
    }

    /**
     * 解法二，直接使用库函数排序字符串数组，然后比较
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isAnagram2(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.equals("") || str2.equals("")) {
            return true;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
