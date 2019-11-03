package com.company.leetcode.editor.cn;//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_242 {

    //数组实现
    public boolean isAnagram(String s,String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //hash表
    public boolean isAnagram1(String s, String t) {

        HashMap<Character,Integer> countMap = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (countMap.containsKey(current)) {
                Integer count = countMap.get(current) + 1;
                countMap.put(current,count);
                continue;
            }
            countMap.put(current,1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character current = t.charAt(i);
            if (countMap.containsKey(current)) {
                Integer count = countMap.get(current) - 1;
                if (count == 0){
                    countMap.remove(current);
                    continue;
                }
                countMap.put(current,count);
                continue;
            }
            return false;
        }

        return countMap.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
