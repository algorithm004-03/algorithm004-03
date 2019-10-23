//283. 移动0

//解法1：双指针
//思路：定义一个慢指针K指向非零元素的index,遍历数组,若当前元素不为0,就在指针K位置赋值为当前元素,赋值后k++
//		这样指针k的前半部分都是非零元素,后半部分补0即可
//时间复杂度为O(n)
//空间复杂度为O(1)
//总结：学会活用指针
public void moveZeroes(int[] nums) {
	int k = 0;
	for (int i = 0; i<nums.length; i++) {
		if (nums[i] != 0) {
			//优化不必要的赋值语句
			if (i != k) {
				nums[k] = nums[i];
			}
			k++;
		}
	}
	for (int i = k; i<nums.length; i++) {
		nums[i] = 0;
	}
}

//解法2：辅助数组
//思路：遍历数组,将非0元素存储到辅助数组中
//时间复杂度O(n)
//空间复杂度O(n)
//总结：和解法1的思想类似,重要的是学会活用指针
public void moveZeroes(int[] nums) {
	int k = 0;
	int[] temp = new int[nums.length];
	for (int i = 0; i<nums.length; i++) {
		if (nums[i] != 0) {
			temp[k++] = nums[i];
		}
	}
	for (int i = 0; i<k; i++) {
		nums[i] = temp[i];
	}

	for (int i = k; i<nums.length; i++) {
		nums[i] = 0;
	}
}