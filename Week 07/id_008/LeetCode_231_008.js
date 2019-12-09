/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n <= 0) {
        return false;
    }

    var len = n.toString(2).length - 1;
    return ((n >> len) << len) === n;
};

/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n <= 0) {
        return false;
    }

    return (n & (n - 1)) === n;
};
