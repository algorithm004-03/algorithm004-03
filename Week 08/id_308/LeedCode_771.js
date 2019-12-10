
/**
 * 题目： 宝石与石头
 * 语言： JavaScript
 * 执行结果： 打败了88.66%的用户
 * */



/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    const arr = S.split('').filter(v=>J.indexOf(v) > -1);
    return arr.length;
};
