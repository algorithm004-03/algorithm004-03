package com.company.leetcode.editor.cn;
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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_49 {

    //key自己计算
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        Map<String,List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count,0);
            String s = strs[i];
            //计算key
            for (int j = 0; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count.length; j++) {
                sb.append(count[j]).append("#");
            }
            String key = sb.toString();
            if (resMap.containsKey(key)) {
                List tmp = resMap.get(key);
                tmp.add(s);
                continue;
            }
            List tmp = new ArrayList();
            tmp.add(s);
            resMap.put(key,tmp);
        }
        return new ArrayList<>(resMap.values());
    }

    //counter作为map的key
    public List<List<String>> groupAnagrams1(String[] strs) {

        //计算每一个的counter
        Map<Map<Character,Integer>,List<String>> counterMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //计算counter
            Map<Character,Integer> counter = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                Character c = strs[i].charAt(j);
                if (counter.containsKey(c)){
                    Integer count = counter.get(c) + 1;
                    counter.put(c,count);
                    continue;
                }
                counter.put(c,1);
            }
            if (counterMap.containsKey(counter)) {
                List<String> list = counterMap.get(counter);
                list.add(strs[i]);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            counterMap.put(counter,list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : counterMap.values()) {
            res.add(value);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
