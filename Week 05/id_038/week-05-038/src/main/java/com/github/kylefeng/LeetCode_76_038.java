/*
 * Enmotech.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.github.kylefeng;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author kylefeng
 * @time 2019/11/15 12:42
 */
public class LeetCode_76_038 {


    public static String solution_by_moving_window(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        // count of all unique chars in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // number of unique chars in t, which need to be present in the desired window.
        int required = dictT.size();

        // moving window pointer
        int l = 0, r = 0;

        int formed = 0;

        // 滑动窗口中，字符出现频率
        Map<Character, Integer> windowCounts = new HashMap<>();

        // (window-length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {

            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - 1 + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
