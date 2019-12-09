package Week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Date 2019/10/27.
 * @see <a href="49">https://leetcode-cn.com/problems/group-anagrams/</a>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class LeetCode_49_558 {

    /**
     * 哈希表法
     * 解题思路：对key排序保证唯一性
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
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

    public static void main(String[] args) {
//        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] arr = {"", "", ""};
        System.out.println(groupAnagrams(arr));
    }
}
