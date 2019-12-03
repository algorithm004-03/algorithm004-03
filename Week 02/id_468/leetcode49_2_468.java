package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description: Group Anagrams
 * @author: 王瑞全
 * @create: 2019-10-2123:37
 **/


public class leetcode49_2_468 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String sorted = String.valueOf(a);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sorted, list);
        }
        List<List<String>> ds = new ArrayList<>();
        for (List<String> d : map.values()) {
            ds.add(d);
        }
        return ds;
    }
}
