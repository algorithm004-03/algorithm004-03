//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_387_443_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new LeetCode_387_443_FirstUniqueCharacterInAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (c == s.charAt(j)) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}