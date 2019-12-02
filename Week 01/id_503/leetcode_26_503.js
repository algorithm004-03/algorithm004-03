/**
 * 统计重复数量法
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
	let count = 0;
	for (let i = 0; i < nums.length; i++) {
		if (nums[i] !== nums[i - 1]) {
			nums[i - count] = nums[i];
			continue;
		}

		count++;
	}

	return nums.length - count;
};