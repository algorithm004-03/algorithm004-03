// 排序比较法
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let sortStringS= s.split('').sort((a, b) => a - b).join('')
    let sortStringT = t.split('').sort((a, b) => a - b).join('')
    return sortStringS === sortStringT
};

// 哈希表解法
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false
    }
    let hashMap = new Array(26)
    for(let i = 0; i < hashMap.length; i++) {
        hashMap[i] = 0
    }
    let firstCode = 'a'.charCodeAt()
    for(let j = 0; j < s.length; j++) {
        hashMap[s[i].charCodeAt() - firstCode]++
        hashMap[t[i].charCodeAt() - firstCode]--
    }
    for(let i = 0; i < hashMap.length; i++) {
        if (hashMap[i] !== 0) {
            return false
        }
    }
    return true
};