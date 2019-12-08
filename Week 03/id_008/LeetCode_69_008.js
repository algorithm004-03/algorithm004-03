/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if (x === 0 || x === 1) {
        return x;
    }

    var L = 0;
    var R = x;
    var m = R / 2;

    while (Math.abs(x - m * m) > 0.001) {
        if (m * m > x) {
            R = m;
            m = (L + R) / 2;
        }
        else {
            L = m;
            m = (L + R) / 2;
        }
    }

    return Math.floor(m);
};
