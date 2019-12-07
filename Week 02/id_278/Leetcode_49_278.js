/**
 * 49. Group Anagrams
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const group = {};
    const result = [];
    
    for (const s of strs) {
        const sorted = s.split('').sort().join('');
        if (group[sorted]) {
            group[sorted].push(s);
        } else {
            group[sorted] = [s];
        }
    }
    
    for (const values of Object.values(group)) {
        result.push(values);
    }
    
    return result;
};
