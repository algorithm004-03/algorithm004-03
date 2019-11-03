// 解法一：双重遍历，时间复杂度O(n*k)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  let temEnd;
  let temPrev;
  for (let i = 0; i < k; i++) {
    temEnd = nums[nums.length - 1];
    for (let j = 0; j < nums.length; j++) {
      temPrev = nums[j];
      nums[j] = temEnd;
      temEnd = temPrev;
    }
  }
};

// 解法二：遍历nums数组k次，每次讲最后一个元素插入到第一个
var rotate = function(nums, k) {
  for (var i = 0; i < k; i++) {
    nums.unshift(nums.pop());
  }
};
