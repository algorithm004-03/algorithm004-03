/*
 * @lc app=leetcode.cn id=22 lang=csharp
 *
 * [22] 括号生成
 */

// @lc code=start
public class Solution {
    IList<string> result = new List<string>();
    public IList<string> GenerateParenthesis(int n) {
        Generate(0,0,n,"");
        return result;
    }
    private void Generate(int left,int right,int max,string str)
    {
        if(left ==max && right==max){
            result.Add(str);
            return;
        }
        
        if(left<max){
            string s1 = str+"(";
            Generate(left+1,right,max,s1);
        }
        if(right<left){
            string s2 = str + ")";
            Generate(left,right+1,max,s2);
        }
    }
}
// @lc code=end

