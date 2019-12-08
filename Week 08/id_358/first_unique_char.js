/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    const set = {}
    s.split('').forEach(i => {
        if(set[i]) {
            set[i] ++
        } else {
            set[i] = 1
        }
    })
    for(let i = 0; i < s.length; i++) {
        if(set[s[i]] === 1){
            return i;
        }
    }
    return -1
};