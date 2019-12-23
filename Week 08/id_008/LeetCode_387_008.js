/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    for (var i = 0; i < s.length; ++i) {
        if (count(s[i]) <= 1) {
            return i;
        }
    }

    return -1;

    function count(w){
        var total = 0;

        for (var i = 0; i < s.length; ++i) {
            if (s[i] === w) {
                ++total;
            }

            if (total >= 2) {
                return 2;
            }
        }

        return total;
    }
};
