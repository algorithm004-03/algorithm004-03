/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {

    let dict = {};
    for (let word of wordList) {
        for (let i = 0; i < word.length; i++) {
            let key = word.substring(0, i) + "*" + word.substring(i + 1);
            dict[key] = dict[key] || new Set();
            dict[key].add(word);
        }
    }    
    let visit = [];
    let findSet = new Set([beginWord]);
    let len = 1;
    while (findSet.size > 0) {
        let childList = new Set();
        len++;
        for (let word of findSet) {
            for (let i = 0; i < word.length; i++) {
                let key = word.substring(0, i) + "*" + word.substring(i + 1);
                if (dict.hasOwnProperty(key)) {
                    let ff = dict[key];
                    if (ff.has(endWord)) {
                        return len;
                    }
                    for (let cc of ff) {
                        if (visit.indexOf(cc) == -1) {
                            childList.add(cc);
                            visit.push(cc)
                        }
                        
                    }
                    
                }
            }
        }
        findSet = childList;
    }
    return 0;
};

// @lc code=end

