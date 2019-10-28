//46. 全排列

//解法1：递归交换
//
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
		//将第i个数与第1个数交换位置
		Collections.swap(numsList, start, i);
		//递归执行
		backtrackMethod(length, numsList, result, start + 1);
		//回溯到交换之前的状态
		Collections.swap(numsList, start, i);
	}
}