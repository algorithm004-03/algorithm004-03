//42. 接雨水

//解法1：暴力解法
//找出数组最大值（最高的柱子），计算每一行的雨水块
//先求高度为1行的水，再求高度为2行的水...
//需要注意的是，最左边和最右边的柱子两侧的空白块不可能会有水
//时间复杂度O(m*n),m为数组最大值
//空间复杂度O(1)
public int trap1(int[] height) {
	int max = 0;
	for (int i = 0;i<height.length;i++) {
		if (max < height[i]) {
			max = height[i];
		}
	}
	int count = 0;
	for (int i = 1;i<=max;i++) {
		int temp = 0;//每一行水块总数
		boolean flag = false;
		for (int j = 0;j<height.length;j++) {
			if(flag && height[j] < i) {
				temp++;
			}
			if(height[j] >= i) {
				count+=temp;
				temp = 0;
				flag = true;
			}
		}
	}
	return count;
}

//解法2：按列求
//除了第一列和最后一列，其他列均可能存在水
//遍历每一列，找出它的左边最高块和右边最高块，若该列小于min(max_left,max_right)，则该列存在水
//水的高度为 min 减去该列的高度
//时间复杂度为O(n^2)
//空间复杂度为O(1)
public static int trap2(int[] height) {
	int sum = 0;
	for (int i = 1;i<height.length-1;i++) {
		int max_left = 0;
		for (int j = i-1;j>0;j--) {
			if (height[j] > max_left) {
			   max_left = height[j];
			}
		}
		int max_right = 0;
		for (int j = i+1;j<height.length-1;j++) {
			if (height[j] > max_right) {
				max_right = height[j];
			}
		}
		int min = Math.min(max_left,max_right);
		if (min > height[i]) {
		   sum = sum+(min-height[i]);
		}
	}
	return sum;
}

