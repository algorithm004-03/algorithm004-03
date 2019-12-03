/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length())
            return false;
        char []s1 = s.toCharArray();
        char []t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        // for(int i=0;i<s1.length;i++){
        //     if(s1[i]!=t1[i])
        //         return false;
        // }
        // return true;
        return Arrays.equals(s1, t1);
    }
}
// @lc code=end

