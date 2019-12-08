/*
 * @lc app=leetcode.cn id=1122 lang=javascript
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    arr1.sort((a, b) => {
        let indexa = arr2.indexOf(a);
        let indexb = arr2.indexOf(b);
        if (indexa != -1 && indexb != -1) {
            return indexa - indexb;
        }
        if (indexa != -1) {
            return -1;
        }
        if (indexb != -1) {
            return 1;
        }
        return a - b;
    });
    return arr1;
};
// @lc code=end

