/**
 * 题目： 两数之和
 * 语言： JavaScript
 * 执行结果： 打败了86%的用户
 * */


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum = function(nums, target) {
    const map = new Map();
    nums.forEach((value,key)=>map.set(value,key));

    for(let i = 0;i < nums.length;i++){
        const temp = target - nums[i];
        if(map.has(temp) && map.get(temp) !== i){
            return [i,map.get(temp)];
        }
    }

    return [];
};
