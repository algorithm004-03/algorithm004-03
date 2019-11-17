/**
 * 双向 BFS
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {

    if (!wordList || !wordList.includes(endWord)) {
        return 0
    }

    const comboWordsDic = generateComboWordsDic(wordList);

    const visitedBeginWords = {};
    visitedBeginWords[beginWord] = 1;
    const visitedEndWords = {};
    visitedEndWords[endWord] = 1;

    let beginQueue = [{ word: beginWord, level: 1 }];
    let endQueue = [{ word: endWord, level: 1 }];

    while (beginQueue.length || endQueue.length) {

        let res = -1;

        [res, beginQueue] =
            processCurrent(beginQueue, comboWordsDic, visitedBeginWords, visitedEndWords);
        if (res != -1) {
            return res;
        }

        [res, endQueue] =
            processCurrent(endQueue, comboWordsDic, visitedEndWords, visitedBeginWords);
        if (res != -1) {
            return res;
        }
    }

    return 0;
}

/**
 * 处理当前字符
 * @param {string[]} queue
 * @param {{}} comboWordsDic
 * @param {{}} visitedWords
 * @param {{}} targetVisitedWords
 * @return {[number, string[]]}
 */
function processCurrent(queue, comboWordsDic, visitedWords, targetVisitedWords) {

    let nextQueue = [];

    for (let node of queue) {
        const w = node.word;
        const level = node.level;

        for (let i = 0; i < w.length; i++) {

            const key = generateKey(w, i);
            const comboWords = comboWordsDic[key];

            if (!comboWords) {
                continue;
            }

            for (let j = 0; j < comboWords.length; j++) {

                const newWord = comboWords[j];
                if (targetVisitedWords[newWord]) {
                    return [level + targetVisitedWords[newWord], []]
                }

                if (!visitedWords[newWord]) {

                    visitedWords[newWord] = level + 1;
                    nextQueue.push({ word: newWord, level: level + 1 });
                }
            }
        }
    }

    return [-1, nextQueue];
}

/**
 * 生产单词组合字典
 * @param {string[]} wordList
 * @return {Object}
 */
function generateComboWordsDic(wordList) {
    const dic = {};
    wordList.forEach(w => {
        for (let i = 0; i < w.length; i++) {
            const key = generateKey(w, i);

            dic[key] ? dic[key].push(w) : dic[key] = [w];
        }
    });

    return dic;
}

/**
 * 生产单词组合字典的 key
 * @param {word} word
 * @param {i} number
 * @return {string}
 */
function generateKey(word, i) {

    return word.substring(0, i) + "*" + word.substring(i + 1, word.length);
}