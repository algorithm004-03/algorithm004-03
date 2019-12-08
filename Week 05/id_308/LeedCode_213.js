/**
 * 题目： 打家劫舍 II
 * 语言： JavaScript
 * 执行结果： 打败了80.70%的用户
 * 方法：动态规划
 * */


/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const len = nums.length;
    if(len < 2) return nums[0] || 0;

    function findMax(arr) {
        arr[1] = Math.max(arr[0],arr[1]);

        for(let i=2;i<len-1;i++) {
            arr[i] = Math.max(arr[i-1],arr[i]+arr[i-2]);
        }

        return arr[len-2];
    }

    const temp1 = findMax(nums.slice(0,-1));
    const temp2 = findMax(nums.slice(1));

    return Math.max(temp1,temp2);
};