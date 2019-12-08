/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */

//  方法四
/* var hammingWeight = function(n) {
    let count = 0;
    while (n) {
        if(n & 1 == 1){
            count++;
        }
        n >>>= 1;
    }
    return count
}; */
 /* 方法三： 正则 */
/* var hammingWeight = function(n) {
    return ((n.toString(2).match(/1/g)) || []).length;
}; */
/* 方法二：位操作技巧 => n & n-1可消去最后一位的一 */
/* var hammingWeight = function(n) {
    let sum =0;
    while(n!=0){
        sum++;
        n &= (n-1);
    }

    return sum;
}; */
 /* 方法一 ： 循环和位移动 */
/* var hammingWeight = function(n) {
    let count = 0;
    let mask = 1;
    for(let i = 0; i < 32; i++){
        if((n & mask)!=0){
            count++;
        }
        mask <<= 1;
    }
    return count
}; */
