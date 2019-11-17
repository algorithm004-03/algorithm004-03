//45. 跳跃游戏

//解法1：从后往前贪心	执行用时击败约14%
//思路：遍历数组, 寻找第一个能够直接跳跃到达终点position的index
//		每当成功寻找到上述index, 更新position=index, count++, 继续重复上述步骤寻找, 直到position = 0
//时间复杂度O(n^2)
//空间复杂度O(1)
public int jump(int[] nums) {
	int count = 0;
	int position = nums.length - 1;
	while (position != 0) {
		for (int i = 0; i < position; i++) {
			if (nums[i] + i >= position) {
				count++;
				position = i;
				break;
			}
		}
	}
	return count;
}

//解法2：贪心算法	执行用时击败约97%
//思路：遍历数组, 每一次遍历都寻找当前位置所能到达的范围内跳的最远的position, 每成功找到一次count++
public int jump(int[] nums) {
	int maxLen = 0;
	int end = 0;
	int count = 0;
	for (int i = 0; i < nums.length - 1; i++) {
		maxLen = Math.max(maxLen, nums[i] + i);
		if (i == end) {
			end = maxLen;
			count++;
		}
	}
	return count;
}