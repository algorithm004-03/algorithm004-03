/** 单词接龙
先预处理 wordList,因为从beginWord到endWord，每次只变换一个字母。
所以循环wordList,取出一个word，循环让word的每个字母替换为*，存到map里，key是替换了*后的word，值是word的数组
这样得到的具有相邻单词的数组
每次使用{word, level} 进行bfs遍历，level每次+1，知道遇到endWord结束；
bfs借助于队列
使用visited数组记录访问过的单词防止重复遍历
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    // 1 预处理wordList
    const len = beginWord.length;
    const map = {}
    wordList.forEach(word => {
        for (let i = 0; i < word.length; i++){
            const transformed = word.substr(0, i) + '*' + word.substr(i + 1)
            if (map[transformed]) {
                map[transformed].push(word)
            } else {
                map[transformed] = [word]
            }
        }
    })
    // bfs
    const queue = [];
    queue.push({ word: beginWord, level: 1 })
    const visited = {}
    visited[beginWord] = true;
    while (queue.length > 0) {
        const node = queue.shift();
        let word = node.word, level = node.level;
        for (let i = 0; i < len; i++){
            const trans = word.substr(0, i) + '*' + word.substr(i + 1);
            if (!map[trans]) continue;
            for (let newWord of map[trans]) {
                if (newWord === endWord) {
                    return level + 1;
                } 
                if (!visited[newWord]) {
                    visited[newWord] = true;
                    queue.push({word:newWord, level: level + 1})
                }
            }
            // 这里使用forEach是错误的，因为forEach中的return不能中止外面的遍历，抛出的异常可以中止遍历。要改成for循环
            // map[trans] && map[trans].forEach(item => {
            //     if (item === endWord) {
            //         return level + 1;
            //     }
            //     if (!visited[item]) {
            //         visited[item] = true;
            //         queue.push({word: item, level: level+1})
            //     }
            // })
        }
    }
    return 0;
};