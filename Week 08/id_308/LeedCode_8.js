
/**
 * 题目： 字符串转换整数 (atoi)
 * 语言： JavaScript
 * 执行结果： 打败了63.59%的用户
 * */


/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    const count =  parseInt(str);
    const Max = Math.pow(2,31)-1;
    const Min = Math.pow(-2,31);
    if(count > Max) return Max;
    if(count < Min) return Min;

    return count || 0;
};
