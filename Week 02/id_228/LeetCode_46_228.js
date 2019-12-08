
// 写法错误，待更新
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let result = []
    let swap = function(a, b) {
        let temp
        temp = a
        a = b
        b = temp
    }
    let backtrack = function(nums, result, i) {
        if (i === nums.length) {
            result.push(nums)
        }
        for (let j = i; j < nums.length; j++) {
            swap(nums[i], nums[j])
            backtrack(nums, result, i+1)
            swap(nums[i], nums[j])
        }
    }
    backtrack(nums, result, 0)
    return result
};