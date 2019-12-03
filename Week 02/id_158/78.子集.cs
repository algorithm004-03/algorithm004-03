/*
 * @lc app=leetcode.cn id=78 lang=csharp
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.00%)
 * Likes:    368
 * Dislikes: 0
 * Total Accepted:    42.1K
 * Total Submissions: 56.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        IList<IList<int>> ans = new List<IList<int>>();
        IList<int> list = new List<int>();
        dfs(ans,list,nums,0);
        return ans;
    }

    private void dfs(IList<IList<int>> ans,IList<int> list,int[] nums,int index){
        if(index == nums.Length){
            ans.Add(list.ToList());
            return;
        }

        dfs(ans,list,nums,index+1);

        list.Add(nums[index]);

        dfs(ans,list,nums,index+1);

        list.RemoveAt(list.Count-1);
    }
}
// @lc code=end

