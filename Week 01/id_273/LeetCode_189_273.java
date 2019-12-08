//189 数组旋转

//1. 暴力解法	执行用时击败约35%
//思路：每次旋转都进行一次arraycopy, 每次旋转后把最后一个元素移动到数组首部
//时间复杂度为O(n*k) 因为arraycopy方法的时间复杂度是O(n)
//空间复杂度为O(1)
public void rotate(int[] nums, int k) {
	k %= nums.length;
	for (int j = k; j > 0; j--) {
		int temp = nums[nums.length - 1];
		System.arraycopy(nums, 0, nums, 1, nums.length - 1);
		nums[0] = temp;
	}
}
	
//2. 使用反转reverse	执行用时击败约91%
//思路：反转所有元素, 然后再反转前k个元素, 再反转后n-k个元素
//		初始：1 2 3 4 5 6
//		反转：6 5 4 3 2 1
//		反转前2个：5 6 4 3 2 1
//		反转后6-2=4个：5 6 1 2 3 4
//时间复杂度O(n)
//空间复杂度O(1)
//总结：三种方法里, 最高效且易理解的题解
public void rotate(int[] nums, int k) {
	k %= nums.length;
	reverse(nums, 0, nums.length - 1);
	reverse(nums, 0, k - 1);
	reverse(nums, k, nums.length - 1);
}

private void reverse(int[] nums, int start, int end) {
	while (start < end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
		start++;
		end--;
	}
}
	
	
//3. 开辟一个新数组, 按正确的位置将值放进去		执行用时击败约91%
//思路：核心在于[(i + k) % nums.length]计算出的即是数组中每一个元素旋转后的位置
//时间复杂度O(n)
//空间复杂度O(n)
//总结：有些类似数学计算.. 正常情况下, 我应该是考虑不到这种类型的解法
public void rotate(int[] nums, int k) {
	int[] temp = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		temp[(i + k) % nums.length] = nums[i];
	}
	for (int i = 0; i < nums.length; i++) {
		nums[i] = temp[i];
	}
}
