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
var relativeSortArray = function (arr1, arr2) {
    let resultPart1 = [];
    resultPart2 = [];
    base = arr1;
    distinct = arr2;

    for (let i = 0; i < base.length; i++) {
        if (!distinct.includes(base[i])) {
            resultPart2.push(base[i]);
        } else {
            resultPart1 = [...resultPart1, ...base.filter((item) => {
                return item === distinct[i];
            })]
        }
    }

    return resultPart1.concat(resultPart2.sort((a, b) => {
        return a - b;
    }))
};
// @lc code=end

