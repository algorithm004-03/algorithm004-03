

/**
 * 题目： 转换成小写字母
 * 语言： JavaScript
 * 执行结果： 打败了54.18%的用户
 * */


/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let str = s.trim();
    if(str.length == 0) return 0;

    const temp = str.split(/\s+/g);
    return temp[temp.length-1].length;
};
