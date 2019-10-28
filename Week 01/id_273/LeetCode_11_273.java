//11. 盛水最多的容器

//1. 暴力解法 
//思路：类似两数之和的暴力解法,通过两次遍历获取不同的组合,计算出每个元素组合的容器大小,获取其中的最大值
//时间复杂度O(n^2)
//空间复杂度O(1)
//总结：重点关注通过两次遍历获取不同组合的遍历方式
public int maxArea(int[] height) {
	int max = 0;
	for (int i = 0; i < height.length-1; i++) {
		for (int j = i + 1; j < height.length;j++) {
			if (Math.min(height[i], height[j]) * (j - i) > max) {
				max = Math.min(height[i], height[j]) * (j - i);
			}
		}
	}
	return max;
}


//2. 双指针解法 
//思路：设置左右指针分别指向数组两端,比较两指针的元素,较小的一段前移,计算每一次移动后的容器大小,直到获取最大值
//时间复杂度O(n) 
//空间复杂度O(1)
public int maxArea(int[] height) {
	int left = 0;
	int right = height.length-1;
	int max = 0;
	while (left < right) {
		int candidate = (right - left) * Math.min(height[left], height[right]);
		max = max < candidate ? candidate : max;
		if (height[left] < height[right]) {
			left++;
		} else {
			right--;
		}
	}
	return max;
}