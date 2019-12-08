/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    var exp = 1, bit = 0;

    for (i = digits.length - 1; i >= 0; --i) {
        bit = digits[i] + exp;

        if (bit > 9) {
            digits[i] = bit - 10;
            exp = 1;
        }
        else {
            digits[i] = bit;
            exp = 0;
        }
    }

    exp && digits.unshift(1);
    return digits;
};
