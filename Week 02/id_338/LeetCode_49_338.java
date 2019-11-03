package id_338;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams
 */
public class LeetCode_49_338 {
    //时间复杂度：O(NKlogK)，其中N是strs的长度，而K是strs中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为O(N)。然后，我们在O(KlogK) 的时间内对每个字符串排序。
    //空间复杂度：O(NK)，排序存储在map中的全部信息内容。
    //思路: 先将strs按字母排序,然后作为key存入hashmap
    //注意这题有个思维误区,可能会选用charAt相加后的数作为hash key, 但这种是不对的,duh和ill的值就相同
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
