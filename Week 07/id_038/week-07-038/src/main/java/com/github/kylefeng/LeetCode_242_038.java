package com.github.kylefeng;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 *
 * @author kylefeng
 * @time 2019/10/26 10:32
 */
public class LeetCode_242_038 {


    /**
     * @param str1
     * @param str2
     * @return
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

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
