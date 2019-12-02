//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
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

package com.modds.alltest.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                Character c = t.charAt(i);
                Integer count = map.get(t.charAt(i));
                if (count != null) {
                    count--;
                    if (count == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, count);
                    }
                } else {
                    return false;
                }
            }
            return map.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}