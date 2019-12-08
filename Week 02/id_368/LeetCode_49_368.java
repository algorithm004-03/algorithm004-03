import java.util.*;

public class LeetCode_49_368 {

    /*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    https://leetcode-cn.com/problems/group-anagrams/*/

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        list.stream().forEach(strArray -> {
            strArray.stream().forEach(str-> System.out.print(str + ""));
        });
        System.out.println();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = String.valueOf(array);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}
