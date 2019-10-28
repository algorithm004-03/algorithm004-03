/**
 * 242. Valid Anagram
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    const count = {};
    
    if (s.length !== t.length) {
        return false;
    }
    
    for (const ch of s) {
        if (count[ch]) {
            count[ch] ++;
        } else {
            count[ch] = 1;
        }
    }
    
    for (const ch of t) {
        if (count[ch]) {
            count[ch] --;
        } else {
            return false;
        }
    }
    
    return Object.values(count).every(value => value === 0);
};
