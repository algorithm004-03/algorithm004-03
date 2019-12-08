/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var cache = [[]];

    gen(n);
    return cache[n];

    function gen(k){
        if (cache[k]) {
            return cache[k];
        }

        if (k <= 0) {
            return [];
        }

        var next = gen(k - 1);
        var _r = [];

        _r.push("()" + (next[0] || ""));

        for (var i = 0; i < next.length; ++i) {
            var arr = next[i].split("");

            for (var j = 0; j < arr.length; ++j) {
                var temp = arr.slice(0);
                temp[j] += "()";
                _r.push(temp.join(""));
            }
        }

        _r = distinct(_r);
        cache[k] = _r;
        return _r;
    }

    function distinct(arr){
        var result = [];

        for (var i = 0; i < arr.length; ++i) {
            !~result.indexOf(arr[i]) && result.push(arr[i]);
        }

        return result;
    }
};

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var result = [];
    putChar("", 0, 0);

    function putChar(s, L, R){
        if (L === n && R === n) {
            result.push(s);
            return null;
        }

        if (L < n) {
            putChar(s + "(", L + 1, R);
        }

        if (R < L) {
            putChar(s + ")", L, R + 1);
        }
    }

    return result;
};
