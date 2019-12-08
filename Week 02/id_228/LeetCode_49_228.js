// 暴力排序
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let tempCode = ''
    let hashMap = {}
    let result = []
    for (let i = 0; i < strs.length; i++) {
        tempCode = strs[i].split('').sort()
        if (!hashMap[tempCode]) {
            hashMap[tempCode] = []
        }
        hashMap[tempCode].push(strs[i])
    }
    Object.keys(hashMap).forEach(key => {
        result.push(hashMap[key])
    })
    return result
};