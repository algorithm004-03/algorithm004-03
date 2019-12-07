
/**
 * 题目： 转换成小写字母
 * 语言： JavaScript
 * 执行结果： 打败了81.24%的用户
 * */


/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    return str.replace(/[A-Z]/g,function(reg){
        return reg ? reg.toLowerCase() : reg;
    })
};


