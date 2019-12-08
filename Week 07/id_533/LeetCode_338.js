// https://leetcode-cn.com/problems/counting-bits/

/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    var countArr = []
    for (var i = 0; i <= num; i++) {
        countArr.push(count(i))
    }
    return countArr;
};

function count(num) {
    var count = 0;
    while (num) {
        count++;
        num = num & (num - 1);
    }
    return count;
}

console.log(countBits(2))
console.log(countBits(5))