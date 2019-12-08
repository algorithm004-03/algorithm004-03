package com.github.kylefeng.week02;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author kylefeng
 * @time 2019/10/27 10:44
 */
public class LeetCode_49_038 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }


        Map<String, List<String>> hash = new HashMap<>();
        for (String s : strs) {
            char[] parts = s.toCharArray();
            Arrays.sort(parts);

            String key = new String(parts);
            List<String> subResult = hash.get(key);
            if (subResult == null) {
                subResult = new LinkedList<>();
                hash.put(key, subResult);
            }
            subResult.add(s);
        }

        List<List<String>> result = new ArrayList<>(hash.size());
        for (String key : hash.keySet()) {
            result.add(hash.get(key));
        }
        return result;
    }


}
