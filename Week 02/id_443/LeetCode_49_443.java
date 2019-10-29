//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package com.modds.alltest.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // hash char  sort
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return Collections.emptyList();
            Map<String, List<String>> sorted = new HashMap<>();
            for (String str : strs) {
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String n = String.valueOf(cs);
                if (sorted.containsKey(n)) {
                    sorted.get(n).add(str);
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(str);
                    sorted.put(n, l);
                }
            }
            return new ArrayList<>(sorted.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}