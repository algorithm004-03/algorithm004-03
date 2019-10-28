//283 移动0

//解法1 双指针
//通过k指针指向非零元素应该存放的位置
//时间复杂度为O(n)
//空间复杂度为O(1)
//但是该方法有一个缺陷，那就是在i=k的时候进行了太多次无用的交换，解法2的代码对其优化
public void moveZeroes(int[] nums) {
	int k = 0;
	for(int i=0;i<nums.length;i++) {
		if (nums[i] != 0) {
			int temp = nums[k];
			nums[k++] = nums[i];
			nums[i] = temp;
		}
	}
}

public void moveZeroes2(int[] nums) {
	int k = 0;
	for(int i = 0;i<nums.length;i++) {
		if (nums[i] != 0) {
			if (i != k) {
				nums[k] = nums[i];
				nums[i] = 0;
			}
			k++;
		}
	}
}

//解法2 也是双指针 只是先进行非零元素的赋值 在最后通过一次循环对零赋值
//优化策略也是跟之前一样 避免i = k时不必要的赋值操作
public static void moveZeroes3(int[] nums) {
	int k = 0;
	for (int i = 0;i<nums.length;i++) {
		if (nums[i] != 0) {
			if(i != k) {
				nums[k] = nums[i];
			}
			k++;
		}
	}
	for (int j = k;j<nums.length;j++) {
		nums[j] = 0;
	}
}