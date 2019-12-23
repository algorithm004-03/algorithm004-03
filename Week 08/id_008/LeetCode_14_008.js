/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (strs.length === 0 || strs[0].length === 0) {
        return "";
    }

    var arr = [];
    var k = 0;

    search: while (true) {
        if (k >= strs[0].length) {
            break;
        }

        var word = strs[0][k];

        for (var i = 1; i < strs.length; ++i) {
            if (strs[i][k] !== word) {
                break search;
            }
        }

        arr.push(word);
        ++k;
    }

    return arr.join("");
};
