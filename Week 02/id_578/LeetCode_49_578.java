package com.hand.week2;

import java.util.*;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/27
 */
public class LeetCode_49_578 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = String.valueOf(chars);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
