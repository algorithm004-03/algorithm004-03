/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateP(0,0,n,"",result);

        return result;
    }

    private static void generateP(int leftNum, int rightNum,int n, String s, List<String> result) {
        //terminator
        if(leftNum == n && rightNum == n){
            result.add(s);
        }
        // process current level logic
        //dill down
        if(leftNum < n){
            generateP(leftNum+1,rightNum,n,s+"(",result);

        }
        if(rightNum < leftNum ){
            generateP(leftNum,rightNum+1,n,s+")",result);

        }


        //reverse states
    }
}
// @lc code=end

