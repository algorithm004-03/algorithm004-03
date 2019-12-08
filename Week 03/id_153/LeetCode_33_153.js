/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = (nums, target) => {
  let low = 0;
  let hight = nums.length - 1;
  while (low < hight) {
    let mid = parseInt((low + hight) / 2, 10);
    if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
      low = mid + 1;
    } else {
      hight = mid;
    }
  }
  return low === hight && nums[low] === target ? low : -1;
};
