/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    return C(m + n - 2, n - 1);

    function C(n, m){
        var k = n - m;
        var r = 1;

        for (var i = n; i > k; --i) {
            r *= i;
        }

        for (var i = m; i > 1; --i) {
            r /= i;
        }

        return r;
    }
};
