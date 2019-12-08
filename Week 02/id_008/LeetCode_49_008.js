/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    var map = {}, result = [];

    for (var i = 0; i < strs.length; ++i) {
        var sArr = strs[i].split("");
        sArr.sort(function(a, b){ return a.charCodeAt(0) - b.charCodeAt(0); });
        var key = sArr.join("");

        if (typeof map[key] === "undefined") {
            map[key] = [];
        }

        map[key].push(strs[i]);
    }

    for (var i in map) {
        result.push(map[i]);
    }

    return result;
};

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    var map = [], result = [];

    for (var i = 0; i < strs.length; ++i) {
        var key = Key(strs[i]);

        if (typeof map[key] === "undefined") {
            map[key] = [];
        }

        map[key].push(strs[i]);
    }

    for (var i in map) {
        result.push(map[i]);
    }

    return result;

    function Key(str){
        var nums = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101];
        var total = 1;

        for (var i = 0; i < str.length; ++i) {
            total *= nums[str.charCodeAt(i) - 97];
        }

        return total;
    }
};
