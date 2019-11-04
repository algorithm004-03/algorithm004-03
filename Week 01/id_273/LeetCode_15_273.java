//15. 三数之和

//解法1：暴力求解	提交超时
//思路：类似于两数之和的暴力求解, 都是通过遍历获取不重复的三数组合, 然后观察相加后是否等于0
//时间复杂度O(n^3)
//空间复杂度O(1)
//总结：加入了一些去重判断尽可能优化了, 虽然调试下来结果应该是正确的, 但提交依然超时, 果然N^3的复杂度还是太高了
public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length - 2; i++) {
		if (nums[i] > 0) break;
		if (i > 0 && nums[i] == nums[i - 1]) continue;
		for (int j = i + 1; j < nums.length - 1; j++) {
			for (int k = j + 1; k < nums.length; k++) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					if (!result.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					}
				}
			}
		}
	}
	return result;
}

//解法2:双指针夹逼法	执行用时击败约98%
//思路：遍历0 ~ length-2, 每次遍历固定一个i指针,然后在i指针之后的数组两端设置左、右指针。
//			当指针所指向的三个元素相加=0, 获取到结果, 存放至list, left和right继续同时夹逼寻找其他可能的三数组合
//			当指针所指向的三个元素相加<0, 左指针右移寻找更大的元素
//			当指针所指向的三个元素相加>0, 右指针左移寻找更小的元素
//		需要额外注意的是一些去重处理, 若处理得当也可以提高算法性能
//时间复杂度O(n^2)
//空间复杂度O(1)
//总结：类似11题的最大容器双指针夹逼解法, 区别仅在于外层多套了一次循环和一些去重判断, 核心就是理解双指针的套路
public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length - 2; i++) {
		//排序后, nums[i]为三数之和中最小的数, 若nums[i] > 0, 则不存在三数之和为0
		if (nums[i] > 0) break;
		//若nums[i]为之前重复出现过的数, 则跳过当前循环
		if (i > 0 && nums[i] == nums[i - 1]) continue;
		int left = i + 1;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[i] + nums[left] + nums[right];
			if (sum == 0) {
				result.add(Arrays.asList(nums[i], nums[left], nums[right]));
				//left去重
				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}
				left++;
				//right去重
				while (left < right && nums[right] == nums[right - 1]) {
					right--;
				}
				right--;
			} else if (sum < 0) left++;
			else right--;
		}
	}
	return result;
}