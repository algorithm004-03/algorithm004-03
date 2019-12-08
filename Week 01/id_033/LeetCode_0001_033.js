/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let map = new Map();

  for (let i = 0, l = nums.length; i < l; i++) {
    const num = target - nums[i];

    if (map.has(num)) {
      return [map.get(num), i];
    }

    map.set(nums[i], i);
  }

  return [];
};
