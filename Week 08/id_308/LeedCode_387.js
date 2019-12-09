
/**
 * 题目： 字符串中的第一个唯一字符
 * 语言： JavaScript
 * 执行结果： 打败了42.39%的用户
 * */



/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let map = new Map();

    for(let i=0;i<s.length;i++) {
        if(map.has(s[i])) {
            map.set(s[i],map.get(s[i]) +1);
        }else map.set(s[i],1);
    }


    for(let i=0;i<s.length;i++) {
        if(map.get(s[i]) == 1) return i;
    }

    return -1;
};
