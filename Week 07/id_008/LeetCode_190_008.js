/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    var result = 0;

    for (var i = 0; i < 32; ++i){
        result = (result << 1) + (n & 1);
        n >>= 1;
    }

    return result >>> 0;
};
