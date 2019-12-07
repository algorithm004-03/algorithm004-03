import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * @author Lukas
 * @since 2019/10/21 22:47
 **/
public class LeetCode_242_138 {

    /**
     * 暴力法:先排序后转换为string比较
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_solution1(String s, String t) {
        char[]ss = s.toCharArray();
        char[]tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        /**
        s = new String(ss);
        t = new String(tt);
        if (s.equals(t)) {
            return true;
        }
        return false;
         **/
        //以上代码可优化为
        return Arrays.equals(ss,tt);
    }

    /**
     * hash表
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_solution2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char ss[] = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (map.containsKey(ss[i])) {
                map.put(ss[i],map.get(ss[i])+1);
            }else
                map.put(ss[i],1);
        }

        char[] tt = t.toCharArray();
        for (int i = 0; i < tt.length; i++) {
            if (map.containsKey(tt[i])) {
                map.put(tt[i],map.get(tt[i])-1);
            }else
                return false;
        }

        for (Integer value : map.values()) {
            if (value!=0)
                return false;
        }
        return true;
    }


    /**
     * 最优题解
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];//代表26个字母个数的数组从a->z排列 table[0]存放的是a的个数,默认是0
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;//字母的个数保存到table中
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i)-'a']--;//将相同字母的个数减一
            if (table[t.charAt(i) - 'a'] < 0) {//如果存在小于0的直接false
                return false;
            }
        }
        return true;
    }

}
