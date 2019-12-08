import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author eazonshaw
 * @date 2019/10/22  20:21
 *
 * 题目：242. 有效的字母异位词
 * 描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_242_243 {

    /**
     * 暴力法
     * 直接对两个字符进行排序，再比较是否相等
     */
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }

    /**
     * 散列表
     * 将字符串的每一项都存入同一个散列表中做计数
     * 遍历散列表，查看散列值是否都为0
     */
    public boolean isAnagram2(String s, String t){

        Map<String,Integer> table = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length != tChars.length){
            return false;
        }
        for(int i=0;i<sChars.length;++i){
            String sKey = String.valueOf(sChars[i]);
            table.put(sKey, table.getOrDefault(sKey, 0)+1);
            String tKey = String.valueOf(tChars[i]);
            table.put(tKey,table.getOrDefault(tKey,0)-1);
        }
        for(Map.Entry<String,Integer> entry:table.entrySet()){
            if (entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 同样是散列表，抛弃高级数据结构，直接用数组解决
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] counts = new int[26];
        for(int i=0;i<s.length();++i){
            counts[s.charAt(i)-'a'] ++;
            counts[t.charAt(i)-'a'] --;
        }
        for(int count:counts){
            if(count!=0){
                return false;
            }
        }
        return true;
    }


}
