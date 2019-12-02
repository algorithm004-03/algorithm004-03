import java.util.Arrays;

/**
 *  给定两个字符串 s 和 t ，
 *  编写一个函数来判断 t 是否是 s 的字母异位词
 */
public class LeetCode_242_648 {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null)return false;
        if(s.trim().equals(t.trim()))return true;
        char[] sarry = s.toCharArray();char[] tarray = t.toCharArray();
        Arrays.sort(sarry);Arrays.sort(tarray);
       return String.valueOf(sarry).equals(String.valueOf(tarray));
    }
    public boolean isAnagram2(String s, String t) {
        if(s==null||t==null)return false;
        if(s.length()!=t.length())return false;
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0)return false;
        }
        return true;
    }


    public static void main(String[] args) {
        LeetCode_242_648 leetCode_242_648 = new LeetCode_242_648();
        String s = "anagram", t = "nagaram";
        System.out.println(leetCode_242_648.isAnagram2(s,t));
    }

}
