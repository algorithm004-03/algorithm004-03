import java.util.*;

public class LeetCode_49_383 {

    /**
     * 将字符串排序，排序后的字符串作为key放入map中，相同key的字符串以链表的形式存储在map中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}