/*
 * @lc app=leetcode.cn id=367 lang=csharp
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
public class Solution {
    public bool IsPerfectSquare(int num) {
        if(num==0){return false;}
        long left =0,right=num;
        while (left<right)
        {
            long mid = left + (right-left)/2;
            long square = mid*mid;
            if(square>num){
                right = mid-1;
            } else if(square<num){
                left = mid+1;
            } else{
                return true;
            }
        }
        return left==right && left*left==num;
    }
}
// @lc code=end

