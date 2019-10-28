//78. 子集

//解法1：回溯
//思路：类似22题的括号生成, 第一个递归函数先运行到最底层, 然后逐层执行二个递归方法
//		对于该题只需要保证获取到所有不重复的组合即可, 下探到最底层从index = 3开始
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(result, nums, list, index + 1);
        list.add(nums[index]);
        dfs(result, nums, list, index + 1);
        list.remove(list.size() - 1);
    }
}