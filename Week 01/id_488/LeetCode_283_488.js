//https://leetcode-cn.com/problems/move-zeroes/
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
// 同时保持非零元素的相对顺序。

/** 
 * 解题思路、方法分析：
 * 1. 遍历数组，将值为0的项从数组删除，最后数组末尾补0（使用js提供的数组方法splice,filter）
 * 2. 遍历数组，累计0的个数m，非零项向前移动m位
 * 3. 遍历数组，维护无0数组的索引
*/
// 方法一
var moveZeroes = function(nums) {
    for (let i=0,len=nums.length; i< len;i++) {
        if (nums[i] === 0) {
            nums.push(nums.splice(i--,1));//注意 i--
            len--;
        }
    }
};

// 方法二 : loop ，无0项数组索引(只关注非0)，补0
var moveZeroes = function(nums) {
    let j=0;
    let len=nums.length;
    for (let i=0; i< len;i++) {
        if (nums[i] !== 0) {
            nums[j] = nums[i];
            j++
        }
    }

    while(j< len) {
        nums[j] = 0;
        j++
    }
};
// 方法二优化
var moveZeroes = function(nums) {
        let j = 0;
        for (let i=0; i<nums.length; ++i) {
            if (nums[i] !=0) {
                nums[j] = nums[i];
                // !!!前面有0 当前索引对应的值置为0
                if (i !=j) {
                    nums[i] = 0;
                }
                j++;
            }

        }
}

// 方法三: loop, 统计0的数量，前移， 补0
var moveZeroes = function (nums) {
    let j = 0;
    let len = nums.length;
    for (let i = 0; i < len; i++) {
        if (nums[i] === 0) {
            j++; // 累计0的个数
        } else {
            nums[i - j] = nums[i];//往前移动的个数
        }

    }
    // 补j个0 
    while (j > 0) {
        nums[len - j] = 0;
        j--;
    }
};
