/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

// 单向 BFS

var ladderLength = function(beginWord, endWord, wordList) {
    if (!~wordList.indexOf(endWord)) {
        return 0;
    }

    var visited = {};
    visited[beginWord] = 1;

    var queue = [beginWord];
    var level = {};

    level[beginWord] = 1;

    while (str = queue.shift()) {
        var search = gen(str);

        for (var i = 0; i < search.length; ++i) {
            if (search[i] === endWord) {
                return level[str] + 1;
            }

            queue.push(search[i]);
            visited[search[i]] = 1;
            level[search[i]] = level[str] + 1;
        }
    }

    return 0;

    function gen(s){
        var result = [];

        for (var i = 0; i < wordList.length; ++i) {
            if (compare(s, wordList[i]) === 1 && !visited[wordList[i]]) {
                result.push(wordList[i]);
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

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

// 双向 BFS

var ladderLength = function(beginWord, endWord, wordList) {
    if (!~wordList.indexOf(endWord)) {
        return 0;
    }

    var bank = [];

    for (var i = 0; i < wordList.length; ++i) {
        ~bank.indexOf(wordList[i]) || bank.push(wordList[i]);
    }

    var compareA = [beginWord];
    var compareB = [  endWord];
    var levelA = 1;
    var levelB = 1;

    while (1) {
        for (var i = 0; i < compareA.length; ++i) {
            for (var j = 0; j < compareB.length; ++j) {
                var cmp = compare(compareA[i], compareB[j]);

                if (cmp < 2) {
                    return levelA + levelB;
                }
            }
        }

        if (levelA <= levelB) {
            var nextA = genAll(compareA);

            if (nextA.length) {
                ++levelA;
                compareA = nextA;
                continue;
            }

            var nextB = genAll(compareB);

            if (nextB.length) {
                ++levelB;
                compareB = nextB;
                continue;
            }

            break;
        }
        else {
            var nextB = genAll(compareB);

            if (nextB.length) {
                ++levelB;
                compareB = nextB;
                continue;
            }

            var nextA = genAll(compareA);

            if (nextA.length) {
                ++levelA;
                compareA = nextA;
                continue;
            }

            break;
        }
    }

    return 0;

    function genAll(arr){
        var result = [];

        for (var i = 0; i < arr.length; ++i) {
            result = result.concat(gen(arr[i]));
        }

        return result;
    }

    function gen(s){
        var result = [];

        for (var i = 0; i < bank.length; ++i) {
            if (compare(s, bank[i]) === 1) {
                result.push(bank[i]);
                bank[i] = bank[bank.length - 1];
                --bank.length;
                --i;
            }
        }

        return result;
    }

    function compare(a, b){
        var total = 0;

        for (var i = 0; i < a.length; ++i) {
            a.charCodeAt(i) === b.charCodeAt(i) || ++total;

            if (total > 1) {
                return 2;
            }
        }

        return total;
    }
};

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

// 双向 BFS 优化

var ladderLength = function(beginWord, endWord, wordList) {
    var bankA = new Set(wordList);
    var bankB = new Set(wordList);

    if (!bankA.has(endWord)) {
        return 0;
    }

    var visitedA = new Map();
    var visitedB = new Map();
    visitedA.set(beginWord, 0);
    visitedB.set(  endWord, 0);

    var queue = [{ level: 0, type: "A", word: beginWord }, { level: 0, type: "B", word: endWord }];
    var check;

    while (check = queue.shift()) {
        if (check.type === "A") {
            if (visitedB.has(check.word)) {
                return check.level + visitedB.get(check.word) + 1;
            }

            genA(check.word).forEach(function(t){
                queue.push({ level: check.level + 1, type: "A", word: t });
                visitedA.set(t, check.level + 1);
            });
        }
        else {
            if (visitedA.has(check.word)) {
                return check.level + visitedA.get(check.word) + 1;
            }

            genB(check.word).forEach(function(t){
                queue.push({ level: check.level + 1, type: "B", word: t });
                visitedB.set(t, check.level + 1);
            });
        }
    }

    return 0;

    function genA(s){
        var result = [];

        gen(s).forEach(function(t){
            if (bankA.has(t)) {
                result.push(t);
                bankA.delete(t);
            }
        });

        return result;
    }

    function genB(s){
        var result = [];

        gen(s).forEach(function(t){
            if (bankB.has(t)) {
                result.push(t);
                bankB.delete(t);
            }
        });

        return result;
    }

    function gen(s){
        var result = [];

        for (let i = 0; i < s.length; ++i) {
            for (let j = 0; j < 26; ++j) {
                s.charCodeAt(i) === j + 97 || result.push(s.substring(0, i) + String.fromCharCode(j + 97) + s.substring(i + 1));
            }
        }

        return result;
    }

    function compare(a, b){
        var total = 0;

        for (var i = 0; i < a.length; ++i) {
            a.charCodeAt(i) === b.charCodeAt(i) || ++total;

            if (total > 1) {
                return 2;
            }
        }

        return total;
    }
};

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
