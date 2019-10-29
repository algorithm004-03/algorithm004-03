/**
 * 题目： 有效的字母异位词
 * 语言： JavaScript
 * 执行结果： 打败了100%的用户
 * */


/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    const set = new Set(s.split(""));

    for(let item of set.keys()) {
        const reg = new RegExp(item,"g");
        const s1 = s.match(reg);
        const s2 = t.match(reg);
        if(!s2 || s1.length !== s2.length) return false;
    }

    return true;
};
