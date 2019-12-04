//47. 全排列II

//解法1：dfs	执行用时击败约98%
public List<List<Integer>> permuteUnique(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();
	Arrays.sort(nums);
	boolean[] flags = new boolean[nums.length];
	dfs(result, temp, flags, nums);
	return result;
}

private void dfs(List<List<Integer>> result, List<Integer> temp, boolean[] flags, int[] nums) {
	if (temp.size() == nums.length) {
		result.add(new ArrayList<>(temp));
		return;
	}
	for (int i = 0; i < nums.length; i++) {
		if (flags[i]) continue;
		if (i > 0 && nums[i - 1] == nums[i] && !flags[i - 1]) continue;
		flags[i] = true;
		temp.add(nums[i]);
		dfs(result, temp, flags, nums);
		flags[i] = false;
		temp.remove(temp.size() - 1);
	}
}