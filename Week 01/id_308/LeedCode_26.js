/**
 * 题目: 删除排序数组中的重复项
 * 思路: 修改数组下标
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
const removeDuplicates = function(nums) {
    let sum = 1;
    let i = 1;
    let maxValue = nums[0];

    const length = nums.length;

    if(!nums || nums.length < 2) return length;

    while (i < length) {
        const temp = nums[i];

        if(temp > maxValue){
            nums[sum++] = temp;
            maxValue = temp;
        }
        i++;
    }

    return sum;
};