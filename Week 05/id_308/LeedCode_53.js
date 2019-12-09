/**
 * 题目： 最大子序和
 * 语言： JavaScript
 * 执行结果： 打败了88.50%的用户
 * 方法：动态规划
 * */


/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let curr = nums[0];
    let sum = 0;

    for(let value of nums) {
        if(sum > 0) {
            sum += value;
        }else{
            sum = value;
        }
        curr = Math.max(curr,sum);
    }

    return curr;
};
