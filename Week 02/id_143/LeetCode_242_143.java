import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 * 暴力法
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length() ){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss); Arrays.sort(tt);
        for(int i=0;i<ss.length;i++){
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

/**
 * 哈希法,居然被暴力法吊打?  估计测试用例无法拉大差距.
 * leetcode上排名前两种算法,过滤测试条件的那些办法针对了一些测试用类,其实不可取。
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length() ){
            return false;
        }

        int[] charsNum = new int [26] ;
        for(int i=0;i< s.length();i++){
            charsNum[s.charAt(i)-'a']++;
            charsNum[t.charAt(i)-'a']--;
        }
        for(int i = 0;i<26;i++){
            if(charsNum[i] !=0)
                return false;
        }
        return true;
    }
}




