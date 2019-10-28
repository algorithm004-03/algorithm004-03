/**
 * 反转法
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
	if (k >= nums.length) {
		k = k % nums.length;
		if (k === 0) { // 表示数组右移动了 x * n (x > 0) 次，相当于不移动
			return;
		}
	}

	reverse(nums, 0, nums.length - 1);
	reverse(nums, 0, k - 1);
	reverse(nums, k, nums.length - 1)
}

/**
 * 反转数组
 * @param {number[]} nums
 * @param {number} start
 * @param {number} end
 * @return {void}
 */
function reverse(nums, start, end) {
	for (; start < end; start++ , end--) {
		let tmp = nums[start];
		nums[start] = nums[end]
		nums[end] = tmp;
	}
}