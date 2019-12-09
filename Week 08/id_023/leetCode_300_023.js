/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
  let n = nums.length;
  if (n <= 1) {
    return n;
  }
  let tail = new Array(n);
  tail[0] = nums[0];
  let end = 0;
  for (let i = 1; i < n; i++) {
    if (nums[i] > tail[end]) {
      end++;
      tail[end] = nums[i];
    } else {
      let left = 0;
      let right = end;
      while (left < right) {
        let mid = left + ((right - left) >> 1);
        if (tail[mid] < nums[i]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      tail[left] = nums[i];
    }
  }
  return end + 1;
};