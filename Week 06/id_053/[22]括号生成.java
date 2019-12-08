//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        process(0,0,n,"");
        return result;
    }
    public void process(int left,int right,int max,String s) {
        //terminal condition
        if (left == max && right == max) {
			result.add(s);
            return;
        }

        //process
        //recursion
        if (left <max) {
            process(left + 1,right,max,s+"(");
        }
        if (right <left) {
            process(left,right+1,max,s+")");
        }
        //clean status if need
    }
}
//leetcode submit region end(Prohibit modification and deletion)
