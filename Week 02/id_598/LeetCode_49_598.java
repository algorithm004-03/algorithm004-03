import java.util.*;

/**
 * LeetCode 第49题
 *
 * @author northleaf
 * @create 2019年10月22日
 */
public class LeetCode_49_598 {


    /**
     * 使用双重循环进行对比
     * 借助一个数组存储元素是否已分类
     * 时间复杂度：O(n²)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        //用于标识是否该字符串已经分类
        boolean[] isUsed = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<String>();
            if (!isUsed[i]) {
                list.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram2(strs[i], strs[j])) {
                        isUsed[j] = true;
                        list.add(strs[j]);
                    }
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }

    public boolean isAnagram2(String s, String t) {
        //如果字符串长度不一致返回false
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 解法2: 此解法要比解法1优
     *  借助哈希表，将具有相同字符及顺序的元素放在一起
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();

        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            //对其排序
            Arrays.sort(chars);
            //以排序后的元素为key值，以原始元素为value添加到map中
            String str_key = String.valueOf(chars);
            if(map.get(str_key)!=null){
                map.get(str_key).add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str_key,list);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}
