/**
  * @param {number[]} nums
  * @return {number}
  */
var removeDuplicates = function (nums) {
  var j = 0;
  var n = nums.length;
  for (let i = 1; i < n; i++) {
    if (nums[i] != nums[i - 1]) {
      j++;
      nums[j] = nums[i];
    }
  }
  return j + 1;
};