//11. 盛水最多的容器

//1. 暴力解法 执行用时击败约30%
//思路：类似两数之和的暴力解法,通过两次遍历获取不同的组合,计算出每个元素组合的容器大小,获取其中的最大值
//时间复杂度O(n^2)
//空间复杂度O(1)
//总结：重点关注通过两次遍历获取不同组合的遍历方式
public int maxArea(int[] nums) {
	int max = 0;
	for (int i = 0; i < nums.length - 1; i++) {
		for (int j = i + 1; j < nums.length; j++) {
			int volume = Math.min(nums[i], nums[j]) * (j - i);
			if (volume > max) {
				max = volume;
			}
		}
	}
	return max;
}


//2. 双指针解法 执行用时击败约96%
//思路：设置左右指针分别指向数组两端,比较两指针的元素,较小的一段前移,计算每一次移动后的容器大小,直到获取最大值
//时间复杂度O(n) 
//空间复杂度O(1)
public int maxArea(int[] nums) {
	int max = 0;
	int left = 0;
	int right = nums.length - 1;
	while (left < right) {
		int volume = Math.min(nums[left], nums[right]) * (right - left);
		max = max < volume ? volume : max;
		if (nums[left] < nums[right]) left++;
		else right--;
	}
	return max;
}