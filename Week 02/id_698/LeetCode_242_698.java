import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @author gning (id 698)
 */


public class LeetCode_242_698 {

    /**
     * 默写官方题解 1
     * @param s
     * @param t
     * @return
     */

    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        Arrays.sort(schar);
        Arrays.sort(tchar);

        return Arrays.equals(schar, tchar);
    }


    /**
     * 默写官方题解2
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] counters = new int[26];

        for (int i=0; i<s.length(); i++) {
            counters[s.charAt(i) - 'a'] ++;
            counters[t.charAt(i) - 'a'] --;
        }

        for(int count: counters) {
            if(count!=0) {
                return false;
            }
        }

        return true;
    }

   


}