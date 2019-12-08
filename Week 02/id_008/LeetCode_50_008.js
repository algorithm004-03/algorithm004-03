/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    var result = x;

    if (n > 0) {
        var m = false;
    }
    else if (n < 0) {
        n = -n;
        var m = true;
    }
    else {
        return 1;
    }

    for (var i = 1; i < n; ++i) {
        result *= x;
    }

    return m ? 1 / result : result;
};

/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    if (n > 0) {
        var m = false;
    }
    else if (n < 0) {
        n = -n;
        var m = true;
    }
    else {
        return 1;
    }

    if (n === 2) {
        return m ? 1 / x / x : x * x;
    }

    if (n % 2) {
        var k = myPow(x, (n - 1) / 2);
        var result = k * k * x;
    }
    else {
        var k = myPow(x, n / 2);
        var result = k * k;
    }

    return m ? 1 / result : result;
};
