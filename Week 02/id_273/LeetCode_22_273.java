//22. 括号生成

//解法1：回溯法
//思路：首先获取到所有可能的括号组合,然后添加约束条件,筛选出所有符合要求的str：
//			左括号可以出现在任意位置,而右括号只能出现在左括号的后面
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backStrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backStrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max*2) {
            res.add(str);
            return;
        }
        if (open < max) {
            backStrack(res, str+"(", open + 1, close, max);
        }
        if (close < open) {
            backStrack(res, str+")", open, close + 1, max);
        }
    }
}