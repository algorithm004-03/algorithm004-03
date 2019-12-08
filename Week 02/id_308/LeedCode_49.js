/**
 * 题目： 字母异位词分组
 * 语言： JavaScript
 * 执行结果： 打败了99.07%的用户
 * */

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
const groupAnagrams = function(strs) {
    let map = new Map();
    let count = 0;
    let result = [];

    strs.forEach(value=>{
        const temp = value.split('').sort().join('');
        if(map.has(temp)) {
            const count = map.get(temp);
            const arr = result[count] || [];
            arr.push(value);
            result[count] = arr;
        }else{
            map.set(temp,count);
            result[count++] = [value];
        }
    });


    return result;
};
