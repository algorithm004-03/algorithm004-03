// https://leetcode-cn.com/problems/minimum-genetic-mutation/

/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
// BFS解法
var minMutation = function (start, end, bank) {
    var queue = [],
        bankSet = new Set(),
        genes = ['A', 'C', 'G', 'T'];
    while (bank.length > 0) bankSet.add(bank.shift());
    if (start) queue.push([start, 0])
    while (queue.length > 0) {
        var cur = queue.shift(),
            times = cur[1];
        cur = cur[0]
        if (cur === end) return times;
        for (var i = 0; i < cur.length; i++) {
            var tmp = cur;
            for (var j = 0; j < genes.length; j++) {
                if (cur[i] === genes[j]) continue;
                cur = cur.slice(0, i) + genes[j] + cur.slice(i + 1);
                if (bankSet.has(cur)) {
                    queue.push([cur, times + 1]);
                    bankSet.delete(cur)
                }
            }
            cur = tmp;
        }
    }
    return -1;
};

/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
// DFS解法
// var minMutation = function(start, end, bank) {
// };
console.log(minMutation("AACCGGTT", "AAACGGTA", ["AACCGGTA", "AACCGCTA", "AAACGGTA"]))
console.log(minMutation("AACCGGTT", "AACCGCTA", ["AACCGGTA","AACCGCTA","AAACGGTA"]))

