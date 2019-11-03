package leetcode.week2;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author eason.feng at 2019/10/22/0022 09:55
 **/
public class LeetCode_49_218 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(sorted,  list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
