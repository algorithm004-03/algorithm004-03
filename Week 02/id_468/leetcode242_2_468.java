package week2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description: Valid Anagram
 * @author: 王瑞全
 * @create: 2019-10-2119:13
 **/


public class leetcode242_2_468 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
    public boolean isAnagram1(String s, String t) {

        int[] store=new int[26];
        for(int i=0;i<s.length();i++) store[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) store[t.charAt(i)-'a']--;
        for (int result:store)if(result!=0) return true;
        return false;
    }

}
