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


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
