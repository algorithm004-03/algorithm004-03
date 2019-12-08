/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(!digits) return [];
    // 用一个map存储数字和对应的字母
    const map = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }
    const res = []
    let tempStr = '';
    search(tempStr, 0, digits);
    
    return res;
    
    function search(tempStr, index, inputStr,) {
        if(index === inputStr.length) { // terminator
            res.push(tempStr)
            return;
        }
        // process
        const letters = map[inputStr.charAt(index)]
        for(let i = 0; i < letters.length; i++) {
            search(tempStr + letters.charAt(i), index+1, inputStr)
        }
        
        //reverse
    }
};