/**
 * 题目： 有效的字母异位词
 * 语言： JavaScript
 * 执行结果： 打败了61.19%的用户
 * */



/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;

    s = s.split('').sort();
    t = t.split('').sort();

    for(let i = 0; i < s.length;i++) {
        if(s[i] !== t[i]) return false;
    }

    return true;
};