/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    var total = 0;

    for (var i = 0; i < S.length; ++i) {
        ~J.indexOf(S[i]) && ++total;
    }

    return total;
};
