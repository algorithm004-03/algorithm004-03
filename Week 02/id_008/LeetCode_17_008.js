/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    var map = [[], [], ["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"], ["j", "k", "l"], ["m", "n", "o"], ["p", "q", "r", "s"], ["t", "u", "v"], ["w", "x", "y", "z"]];
    var cache = {};
    return gen(digits);

    function gen(nums){
        if (nums.length <= 0) {
            return [];
        }

        if (typeof cache[nums] !== "undefined") {
            return cache[nums];
        }

        var a = +nums.charAt(0);
        var sub = gen(nums.substring(1));
        var result = [];

        if (nums.length === 1) {
            cache[nums] = map[a];
            return map[a];
        }

        for (var i = 0; i < map[a].length; ++i) {
            for (var j = 0; j < sub.length; ++j) {
                result.push(map[a][i] + sub[j]);
            }
        }

        cache[nums] = result;
        return result;
    }
};
