/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let longest = 0;
    let current = 0;
    let start = 0;
    for (let i = 0; i < s.length; i++) {
        //find length for "aba"
        current = findLength(s, i, i);
        if (current > longest) {
            longest = current;
            start = i - Math.floor(current / 2);
        }
        
        //find length for "abba"
        current = findLength(s, i, i + 1);
        if (current > longest) {
            longest = current;
            start = i - Math.floor(current / 2) + 1;
        }
    }
    return s.substring(start, start + longest);
};

function findLength(s, left, right) {
    let length = 0;
    while (left >= 0 && right < s.length) {
        if (s[left] !== s[right]) {
            break;
        }
        length += left === right ? 1 : 2;
        left--;
        right++;
    }
    return length;
}
