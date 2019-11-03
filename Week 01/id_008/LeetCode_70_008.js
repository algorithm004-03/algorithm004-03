/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    var t = Math.sqrt(5);
    return Math.round(1/t * (Math.pow((1+t)/2, n+1) - Math.pow((1-t)/2, n+1)));
};

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n < 2) {
        return 1;
    }

    var a = 1;
    var b = 1;

    for (var i = 1; i < n; ++i) {
        b += a;
        a = b - a;
    }

    return b;
};
