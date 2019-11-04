
import java.util.ArrayList;
import java.util.List;



/*
思路

设序列数字个数为n
进行n层递归，每一层从剩余数字中从小到大选择一个数字，去掉选择的数字剩下的数字再进行下一层递归，
递归深度为n时候可以生成一种结果，所有路径遍历完，所有可能的结果也就得到了

 */

class Solution {

    private List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> path, int[] choice, int[] nums, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            result.add(new ArrayList<Integer>(path));
            return result;
        }

        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 0) {
                choice[i] = 1;
                path.add(nums[i]);
                dfs(result, path, choice, nums, curLevel+1, maxLevel);

                // 恢复现场
                choice[i] = 0;
                path.remove(path.size() - 1);
            }
        }

        return result;
    }

    // 计算排列数
    private int getPermuteNum(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }

        return total;
    }

    public List<List<Integer>> permute(int[] nums) {
        return dfs(new ArrayList<List<Integer>>(getPermuteNum(nums.length)), new ArrayList<Integer>(nums.length), new int[nums.length], nums, 0, nums.length);
    }
}
