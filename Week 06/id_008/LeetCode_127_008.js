/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

// 双向 BFS 优化

var ladderLength = function(beginWord, endWord, wordList) {
    var dict = new Set(wordList);

    if (!dict.has(endWord)) {
        return 0;
    }

    var queueA = [beginWord];
    var queueB = [  endWord];
    var levelA = {};
    var levelB = {};
    levelA[beginWord] = 1;
    levelB[  endWord] = 1;

    var level;

    while (queueA.length && queueB.length) {
        level = check(queueA, levelA, queueB, levelB);

        if (level) {
            return level;
        }

        level = check(queueB, levelB, queueA, levelA);

        if (level) {
            return level;
        }
    }

    return 0;

    function check(thisQ, thisL, thatQ, thatL){
        var word = thisQ.shift();
        var plus = thisL[word] + 1;
        var list = gen(word);

        for (var i = 0; i < list.length; ++i) {
            if (thisL[list[i]]) {
                continue;
            }

            if (thatL[list[i]]) {
                return thisL[word] + thatL[list[i]];
            }

            thisQ.push(list[i]);
            thisL[list[i]] = plus;
        }

        return 0;
    }

    function gen(s){
        var result = [];

        for (var i = 0; i < s.length; ++i) {
            for (var j = 0; j < 26; ++j) {
                var word = s.substring(0, i) + String.fromCharCode(j + 97) + s.substring(i + 1);
                dict.has(word) && word !== s && result.push(word);
            }
        }

        return result;
    }
};
