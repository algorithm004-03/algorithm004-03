//42. 接雨水

//解法1：暴力解法	提交超时
//思路：找出数组最大值（最高的柱子），计算每一行的雨水块
//			先求高度为1行的水，再求高度为2行的水...
//		需要注意的是，最左边和最右边的柱子两侧的空白块不可能会有水
//		之所以在height[j] >= i时才count += temp, 是因为若当前行只有一个柱子, 不应该存在积水, 
//			若该柱子右边不存在第二个柱子, 那么之前添加到temp中的雨水数就不能添加到count 
//时间复杂度O(m*n),m为数组最大值
//空间复杂度O(1)
public int trap(int[] height) {
	int max = 0;//最大高度
	for (int i = 0; i < height.length; i++) {
		if (max < height[i]) max = height[i];
	}
	int count = 0;
	for (int i = 1; i <= max; i++) {
		int temp = 0;
		boolean flag = false;
		for (int j = 0; j < height.length; j++) {
			if (flag && height[j] < i) temp++;
			if (height[j] >= i) {
				count += temp;
				temp = 0;
				flag = true;
			}
		}
	}
	return count;
}

//解法2：按列求		执行用时击败约16%
//思路：遍历除了第一列和最后一列的每一列, 找出它的左边最高块和右边最高块, 
//		只有当左边最高列和右边最高列的高度都大于当前列, 才能使当前列积水, 且积水量为min(left_max, right_max) - nums[i]
//时间复杂度为O(n^2)
//空间复杂度为O(1)
public int trap(int[] height) {
	int count = 0;
	for (int i = 1; i < height.length; i++) {
		int max_left = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (height[j] > max_left) max_left = height[j];
		}
		int max_right = 0;
		for (int j = i + 1; j < height.length; j++) {
			if (height[j] > max_right) max_right = height[j];
		}
		int min = Math.min(max_left, max_right);
		count += min > height[i] ? min - height[i] : 0;
	}
	return count;
}

//解法3：动态规划		执行用时击败100%
//思路：基于题解2按列求的思路, 构建两个数组, max_left[i]代表第i列左边最高的列高度, max_right[i]代表第i列右边最高的列高度
//		这样就不必每次求max_left和max_right都遍历一次数组了
//时间复杂度O(n)
//空间复杂度O(n)
public int trap(int[] height) {
	int sum = 0;
	int[] max_left = new int[height.length];
	int[] max_right = new int[height.length];
	for (int i = 1; i < height.length; i++) {
		max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
	}
	for (int i = height.length - 2; i > 0; i--) {
		max_right[i] = Math.max(height[i + 1], max_right[i + 1]);
	}
	for (int i = 1; i < height.length - 1; i++) {
		int min = Math.min(max_left[i], max_right[i]);
		sum += min > height[i] ? min - height[i] : 0;
	}
	return sum;
}

//解法4：双指针		执行用时击败约75%
//思路：基于解法3动态规划, 可以成功将max_left数组采用变量暂存, 但是对于max_right数组是从右向左遍历的, 因此不能同时把max_right数组用变量替代, 那么就可以通过双指针解决
//		对于按列求的方法中, 最后都需要寻找左边和右边列最大值中的较小值 : Math.min(left_max, right_max)		
//		而对于变量max_left的计算可以通过代码"max_left = Math.min(max_left, height[i - 1])"
//		同理对变量max_right也可以通过代码"max_right = Math.min(max_right, height[i + 1])"
//		由于max_left与max_right最开始都是基于height[left - 1], height[right + 1]计算得出, 那么只要保证height[left - 1] < height[right + 1], max_left就一定小于max_right
//		那么就可以划分为两种情况：
//			1. 如果height[left - 1] < height[right + 1]: 可以确定max_left小于max_right, 那么就可以省略寻找右侧的操作, 只需要比较max_left和当前height[left]的大小并计算雨水量即可
//			2. 同理可得else的情况
//时间复杂度O(n)
//空间复杂度O(1)
public int trap(int[] height) {
	int count = 0;
	int left = 1;
	int right = height.length - 2;
	int max_left = 0;
	int max_right = 0;
	for (int i = 1; i < height.length - 1; i++) {
		if (height[left - 1] < height[right + 1]) {
			max_left = Math.max(max_left, height[left - 1]);
			count += max_left > height[left] ? max_left - height[left] : 0;
			left++;
		} else {
			max_right = Math.max(max_right, height[right + 1]);
			count += max_right > height[right] ? max_right - height[right] : 0;
			right--;
		}
	}
	return count;
}

//解法5：栈		执行用时击败约32%
//思路：当前高度若小于等于栈顶元素(当前左边界), 入栈(成为新的左边界), 指针后移
//		若当前高度大于栈顶元素, 说明栈顶元素X与其左右边界存在高度差, 也就是能够接雨水, 计算左右边界之间的水。
//			直到当前高度不大于栈顶高度或者栈空位置, 然后当前高度作为新的左边界入栈, 指针后移
public int trap(int[] height) {
	int sum = 0;
	Stack<Integer> stack = new Stack<>();
	int curr = 0;
	while (curr < height.length) {
		while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
			int h = height[stack.pop()];
			if (stack.isEmpty()) break;
			int distance = curr - stack.peek() - 1;
			int min = Math.min(height[stack.peek()], height[curr]);
			sum += min > h ? distance * (min - h) : 0;
		}
		stack.push(curr);
		curr++;
	}
	return sum;
}



