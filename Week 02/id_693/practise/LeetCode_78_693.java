package id_693.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc  78. 子集  https://leetcode-cn.com/problems/subsets/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/27
 */
public class LeetCode_78_693 {
    //回溯，类似之前的组合的题目
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list,List<Integer> temp,int[] nums,int first){
        list.add(new ArrayList<>(temp));
        for (int i = first; i < nums.length;i++) {
            temp.add(nums[i]);
            backtrack(list,temp,nums,i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

    输入: nums = [1,2,3]
    输出:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
