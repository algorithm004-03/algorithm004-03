import java.util.*;

/**
 * 49. 字母异位词分组
 * @Author CJ
 * @create 2019/10/27
 */

public class LeetCode_49 {
    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = LeetCode_49.groupAnagrams(str);
        for (List<String> list:
                result ) {
            for (String s:
                 list) {
                System.out.println(s);
            }
        }
    }
    //哈希表
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }

        Map<String , ArrayList> map = new HashMap<>();
        for (String str:
             strs) {
            char[] toCharArray = str.toCharArray();
            Arrays.sort(toCharArray);
            String toString = String.valueOf(toCharArray);
            if(!map.containsKey(toString)){
                map.put(toString, new ArrayList());
            }
            map.get(toString).add(str);
        }
        return new ArrayList(map.values());
    }
}