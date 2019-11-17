var ladderLength = function(beginWord, endWord, wordList) {
    //记录单词长度，用作下一步的循环变量
    let l = beginWord.length;
    //创建字典，用于保存单词的通用状态。
    let allComboDict = {}
    let q = [];

    for (const word of wordList) {
      for (let i = 0; i < l; i++) {
        let newWord = word.replace(word[i],'*');
        let tempList = allComboDict[newWord] || []
        tempList.push(word);
        allComboDict[newWord] = allComboDict[newWord]=tempList 
    }      
    }
    // console.log(allComboDict);
    
    // bfs();
    let visited = {};
    q.push([beginWord,1]);
    visited[beginWord] = true;

    while (q.length>0) {
        let node = q.shift();
        let level = node[1];
        let word = node[0];
        
        for (let i = 0; i < l; i++) {
            let newWord = word.replace(word[i],'*');

            let mapList = (allComboDict[newWord] || []);
            for (const word of mapList) {
              
              if(word == endWord){
                return level+1;
              }
              
              if(! (word in visited)) {
                  visited[word] = true;
                  q.push([word,level+1]);
              }
            }
        }
    }
    return 0
};