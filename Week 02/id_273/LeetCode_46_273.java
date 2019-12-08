//46. 全排列

//解法1：递归交换	提交时间击败100%
public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> numsList = new ArrayList<>();
	for (int num : nums) {
		numsList.add(num);
	}
	backtrackMethod(nums.length, numsList, result, 0);
	return result;
}

private void backtrackMethod(int length, List<Integer> numsList, List<List<Integer>> result, int start) {
	//terminate: 当标志位start = length, 将当前numsList的结果添加到result
	if (start == length) {
		result.add(new ArrayList<>(numsList));
		return;
	}
	for (int i = start; i < length; i++) {
		//将第i个数与当前递归层的第1个数交换位置
		Collections.swap(numsList, start, i);
		//drill down
		backtrackMethod(length, numsList, result, start + 1);
		//回溯到交换之前的状态
		Collections.swap(numsList, start, i);
	}
}


//解法2：回溯去重	执行用时击败约65
//思路：深度优先递归, 判断当前遍历获取的nums[i]之前是否出现过, 
//			若出现过, continue跳过当前循环
//			若未出现, list.add(nums[i])
public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> list = new ArrayList<>();
	permutations(nums, result, list);
	return result;
}

private void permutations(int[] nums, List<List<Integer>> result, List<Integer> list) {
	if (list.size() == nums.length) {
		result.add(new ArrayList<Integer>(list));
		return;
	}
	for (int i = 0; i < nums.length; i++) {
		if(list.contains(nums[i])) continue;
		list.add(nums[i]);
		permutations(nums, result, list);
		list.remove(list.size() - 1);
	}
}