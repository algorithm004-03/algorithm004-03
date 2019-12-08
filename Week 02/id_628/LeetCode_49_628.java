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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_49_628 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)return new ArrayList<List<String>>();
        HashMap<String , List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key))map.put(key , new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
