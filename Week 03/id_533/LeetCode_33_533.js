// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    var left = 0,
        right = nums.length - 1;
    while (left <= right) {
        var mid = left + Math.floor((right - left) / 2);
        if (nums[mid] === target) return mid;
        // 划分后的数组总有一边是有序的
        if (nums[mid] >= nums[left]) { // 划分后的数组左边有序
            if (target >= nums[left] && target < nums[mid])
                right = mid - 1;
            else 
                left = mid + 1;
        } else { // 划分后的数组右边有序
            if (target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    return -1;
};

console.log(search([4,5,6,7,0,1,2], 0))
console.log(search([4,5,6,7,0,1,2], 3))

