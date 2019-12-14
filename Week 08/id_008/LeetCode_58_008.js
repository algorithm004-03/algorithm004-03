/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    var arr = s.split(" ");

    for (var i = arr.length - 1; i >= 0; --i) {
        if (arr[i].length > 0) {
            return arr[i].length;
        }
    }

    return 0;
};

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    return s.trim().split(" ").pop().length;
};
