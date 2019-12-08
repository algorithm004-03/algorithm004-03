//78. 子集

//解法1：回溯	执行时间超越99%
//思路：参考77. 组合, for循环的结束条件就是递归的结束条件, 每次drill down都添加当前list中的元素到result
//总结：对于子集, 组合, 全排列这类题, 递归的思路都差不太多, 每次做完这种题都会忘, 希望再多做几遍后能够看到问题的本质。
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}