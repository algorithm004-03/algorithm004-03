/**
 * 题目： 比特位计数
 * 语言： JavaScript
 * 执行结果： 打败了83.64%的用户
 * */

/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    const res = [];
    for(let i=0;i<=num;i++) res[i] = totalCount(i);
    return res;
};

function totalCount(n) {
    let count = 0;
    while(n) {
        n &= (n-1);
        count++;
    }
    return count;
}
