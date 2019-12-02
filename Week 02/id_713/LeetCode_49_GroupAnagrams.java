package id_713;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class LeetCode_49_GroupAnagrams {
    /*
    思路:
    1. 遇到分组, 则必须定义统一格式的key
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); // 定义用于分组的map, key:有共性的摘要值, value:异位词的集合

        for (int i = 0; i < strs.length; i++) {
            // 统计词频, 用于构建key
            int[] nums = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                nums[strs[i].charAt(j) - 'a']++;
            }

            // 转成 0#1#2 这种格式
            String key = "";
            for (int j = 0; j < nums.length; j++) {
                key = key + nums[j] + "#";
            }

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(key, tmp);
            }
        }

        return new ArrayList<>(map.values());
    }

    /*
    8秒钟的案例
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 找到相同的字符串，主要是排序不一样
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = sort(str);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }

        String sort(String str) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            return String.valueOf(c);
        }
    }
    */
}
