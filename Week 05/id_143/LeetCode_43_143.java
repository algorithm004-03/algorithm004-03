import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */
//利用栈来实现,栈里记录字符数组的下标。
// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int maxN = 0;
        Stack<Integer> a = new Stack<Integer>();
        a.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                a.push(i);
            }else{
                a.pop();
                if(a.isEmpty()){
                    a.push(i);
                }else{
                    maxN = Math.max(maxN, (i - a.peek()));
                }
            }
        }
        return maxN;
    }
}
// @lc code=end

