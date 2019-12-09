import java.util.*;


/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @author gning (id=698)
 */
public class LeetCode_49_698 {

    /**
     * 默写官方题解
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List> ans = new HashMap<String,List>();

        for(String s:strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());

    }
}