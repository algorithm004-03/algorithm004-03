/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    return s.split(' ').map(item => item.split('').reverse().join('')).join(' ')
};