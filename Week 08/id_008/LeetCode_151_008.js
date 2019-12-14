/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    return s.split(" ").reverse().join(" ").trim().replace(/([\s]+)/g, " ");
};
