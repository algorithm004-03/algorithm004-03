/**
 * 引入 map, 空间换时间
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
	const map = new Map();

	for (let i = 0; i < nums.length; i++) {
		const key = target - nums[i];
		const value = map.get(key);
		if (value !== undefined) {
			return [value, i];
		}

		map.set(nums[i], i);
	}

	return []
};