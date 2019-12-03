/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    if (!~bank.indexOf(end)) {
        return -1;
    }

    var visited = [start];
    var queue = [start];
    var level = {};
    var node;
    var str;

    level[start] = 0;

    while (str = queue.shift()) {
        var search = gen(str);

        for (var i = 0; i < search.length; ++i) {
            if (search[i] === end) {
                return level[str] + 1;
            }

            queue.push(search[i]);
            visited.push(search[i]);
            level[search[i]] = level[str] + 1;
        }
    }

    return -1;

    function gen(s){
        var result = [];

        for (var i = 0; i < bank.length; ++i) {
            if (compare(s, bank[i]) === 1 && !~visited.indexOf(bank[i])) {
                result.push(bank[i]);
            }
        }

        return result;
    }

    function compare(a, b){
        var total = 0;

        for (var i = 0; i < 8; ++i) {
            a.charAt(i) === b.charAt(i) || ++total;

            if (total > 1) {
                return 2;
            }
        }

        return total;
    }
};
