package week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_333 {
    public  static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            //排序
            Arrays.sort(s_arr);
            //映射到 key
            String key = String.valueOf(s_arr);
            //添加到对应的类中
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }

    public static void main(String[] args) {
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(words);
        for(List<String> list : result) {
            System.out.print("[");
            for(String word : list) {
                System.out.print("\"" + word + "\"");
            }
            System.out.println("]");
        }
    }
}
