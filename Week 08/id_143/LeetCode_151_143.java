/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {

        String[] strs = s.split(" +");
        StringBuffer result = new StringBuffer();
        for(int i=strs.length -1 ;i>=0;i--){
            if(!strs[i].equals("")){
                result.append(strs[i].trim()+" ");
            }

        }
        if(result.length() > 0){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();

    }
}
// @lc code=end

