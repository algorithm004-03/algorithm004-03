//283. 移动0

//解法1：双指针		执行用时击败约100%
//思路：定义慢指针k, 遍历数组若nums[i]!=0, 则覆盖指针k所指向的位置, 遍历结束后末尾补0即可
//时间复杂度为O(n)
//空间复杂度为O(1)
public void moveZeroes(int[] nums) {
	int k = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] != 0) {
			nums[k++] = nums[i];            
		}
	}
	for (int i = k; i < nums.length; i++) {
		nums[i] = 0;
	}
}

//解法2：辅助数组		执行用时击败约100%
//思路：遍历数组,将非0元素存储到辅助数组中
//时间复杂度O(n)
//空间复杂度O(n)
//总结：和解法1的思想类似, 区别就在于一个是操作源数组, 一个开辟了新数组, 考虑到内存消耗, 还是第一种更好一些
public void moveZeroes(int[] nums) {
	int k = 0;
	int[] temp = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] != 0) {
			temp[k++] = nums[i];
		}
	}
	for (int i = 0; i < temp.length; i++) {
		nums[i] = temp[i];
	}
}