/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    var cache = {};
    return gen(s);

    function gen(str){
        if (typeof cache[str] === "number") {
            return cache[str];
        }

        if (str.length <= 0) {
            cache[str] = 0;
            return 0;
        }

        if (str.charAt(0) === "0") {
            cache[str] = 0;
            return 0;
        }

        if (str.length === 1) {
            if (str === "0") {
                cache[str] = 0;
                return 0;
            }

            return 1;
        }

        if (str.length === 2) {
            var k = +str;

            if (k <= 26) {
                if (k % 10 === 0) {
                    cache[str] = 1;
                    return 1;
                }
                else {
                    cache[str] = 2;
                    return 2;
                }
            }
            else {
                if (k % 10 === 0) {
                    cache[str] = 0;
                    return 0;
                }
                else {
                    cache[str] = 1;
                    return 1;
                }
            }
        }

        var total = gen(str.substring(1));
        var two = str.charAt(0) * 10 + +str.charAt(1);

        if (two <= 26) {
            cache[str] = total + gen(str.substring(2));
            return cache[str]
        }

        cache[str] = total;
        return total;
    }
};
