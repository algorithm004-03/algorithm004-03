// https://leetcode-cn.com/problems/word-ladder/

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
// BFS解法
var ladderLength = function(beginWord, endWord, wordList) {
    var queue = [],
        words = [],
        listSet = new Set();
    for (var i = 0; i < 26; i++) words.push(String.fromCharCode(97 + i));
    while (wordList.length > 0) listSet.add(wordList.shift());
    if (beginWord) queue.push([beginWord, 1]);
    while (queue.length > 0) {
        var cur = queue.shift(),
            times = cur[1];
        cur = cur[0];
        if (cur === endWord) return times;
        for (var i = 0; i < cur.length; i++) {
            var tmp = cur;
            for (var j = 0; j < words.length; j++) {
                if (cur[i] === words[j]) continue;
                cur = cur.slice(0, i) + words[j] + cur.slice(i + 1);
                if (listSet.has(cur)) {
                    queue.push([cur, times + 1]);
                    listSet.delete(cur);
                }
            }
            cur = tmp;
        }
    }
    return 0; 
};

console.log(ladderLength("a", "c", ["a","b","c"]));
console.log(ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]));