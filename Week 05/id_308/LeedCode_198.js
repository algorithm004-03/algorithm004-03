
/**
 * 题目： 打家劫舍
 * 语言： JavaScript
 * 执行结果： 打败了16.41%的用户
 * 方法：动态规划
 * */

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const len = nums.length;

    if(len < 2) return nums[0] || 0;
    nums[1] = Math.max(nums[0],nums[1]);

    for(let i=2;i<len;i++) {
        nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
    }

    return nums[len-1];
};
