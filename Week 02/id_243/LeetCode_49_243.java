import java.util.*;

/**
 * @author eazonshaw
 * @date 2019/10/22  21:36
 *
 * 题目：49. 字母异位词分组
 * 描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 * 示例：
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode_49_243 {

    /**
     * 新建一个hash表，将strs中元素的排序后值作为key，List作为value，返回hash表
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> hash = new HashMap<>();

        for(String str:strs){
            char[] chars = str.toCharArray();
            //排序
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            //初始
            if(!hash.containsKey(key)){
                hash.put(key,new ArrayList<>());
            }
            List<String> list = hash.get(key);
            list.add(str);
            hash.put(key,list);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:hash.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }

}
