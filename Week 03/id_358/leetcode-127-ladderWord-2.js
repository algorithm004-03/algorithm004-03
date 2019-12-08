/** 单词接龙
先预处理 wordList,因为从beginWord到endWord，每次只变换一个字母。
所以循环wordList,取出一个word，循环让word的每个字母替换为*，存到map里，key是替换了*后的word，值是word的数组
这样得到的具有相邻单词的数组
每次使用{word, level} 进行bfs遍历，level每次+1，知道遇到endWord结束；
bfs借助于队列
使用visited数组记录访问过的单词防止重复遍历
使用两个队列，从开头和结尾同时遍历，如果相关，则找到结果
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    // 1 预处理wordList
    const Len = beginWord.length; // 每个单词长度一样
    const map = {}
    wordList.forEach(word => {
        for (let i = 0; i < Len; i++){
            const transformed = word.substr(0, i) + '*' + word.substr(i + 1)
            if (map[transformed]) {
                map[transformed].push(word)
            } else {
                map[transformed] = [word]
            }
        }
    })
    // bfs
    const begin_queue = [];
    begin_queue.push({ word: beginWord, level: 1 })
    const end_queue = [];
    end_queue.push({ word: endWord, level: 1 })
    const begin_visited = {}
    const end_visited = {}
    begin_visited[beginWord] = 1;
    end_visited[endWord] = 1;
    let res;
    while (begin_queue.length > 0 && end_queue.length > 0) {
        debugger
        res = visitNode(begin_queue, begin_visited, end_queue, end_visited)
        if (res) {
            return res;
        }
        res = visitNode(end_queue, end_visited, begin_queue, begin_visited)
        if (res) {
            return res;
        }
    }
    //任意一个队列遍历完毕且没有找到结果返回失败结果
    return 0;
    function visitNode(begin_queue, begin_visited, end_queue, end_visited) {
        const newWord = begin_queue.shift();
        let word = newWord.word, level = newWord.level;
        for (let i = 0; i < Len; i++){
            const trans = word.substr(0, i) + '*' + word.substr(i + 1);
            if (!map[trans]) continue;
            for (let item of map[trans]) {
                // 前后两个队列相交，结束
                if (end_visited[item]) {
                    return level + end_visited[item];
                } 
                // 开始队列还没遍历过，添加进去
                if (!begin_visited[item]) {
                    begin_visited[item] = level + 1;
                    begin_queue.push({word:item, level: level + 1})
                }
            }
        }
        return 0;
    }
    return 0;
};