package id_693;

import java.util.*;

/**
 * @Desc 47. 全排列 II   https://leetcode-cn.com/problems/permutations-ii/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/26
 */
public class LeetCode_47_693 {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] used ;


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, new Stack<>(), 0);
        return list;
    }

    // 思路:先排序
    /*
        1、先用枚举穷举所有结果
        2、开始剪枝：
                使用一个布尔数组来作为条件，如果数组中加了这个元素，那么就跳过，如果没有则继续下去。最后回溯的时候处理状态为false，restore current status
                布尔数组默认是false；如果只有当前是true那么说明这个元素添加过了
     */
    private void backtrack(int [] nums, Stack<Integer> stack, int first) {
        if (first == nums.length) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                backtrack(nums, stack, first + 1);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_47_693().permuteUnique(new int[]{1, 1, 2}));
    }
    /*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

    输入: [1,1,2]
    输出:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
在真实

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

}
