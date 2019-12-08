/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if (num === 0 || num === 1) {
        return true;
    }

    var L = 0;
    var R = num;
    var m = Math.floor(R / 2);

    while (m * m > num || (m + 1) * (m + 1) <= num) {
        if (m * m > num) {
            R = m;
            m = Math.floor((L + R) / 2);
        }
        else if ((m + 1) * (m + 1) <= num) {
            L = m;
            m = Math.floor((L + R) / 2) + 1;
        }
    }

    return m * m === num;
};
