/**
 * 题目： 单词搜索 II
 * 语言： JavaScript
 * 执行结果： 打败了93.10%的用户
 * */


/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {

    const root = new Tride();
    for(let word of words) {
        root.insert(word);
    }

    const result = [];

    for(let i=0;i<board.length;i++) {
        for(let j=0;j<board[i].length;j++) {
            tranversing(root,board,i,j,result,'');
        }
    }

    return result;
};


function tranversing(tride,board,row,col,res,str) {

    if(tride.end_word) {
        res.push(str);
        tride.end_word = false;
    }

    if(!canWalk(board,row,col)) return;

    const ch = board[row][col];
    const dx = [-1,1,0,0];
    const dy = [0,0,-1,1];
    if(!tride.nexts.has(ch)) return;

    board[row][col] = '';
    for(let i=0;i<4;i++) tranversing(tride.nexts.get(ch),board,row+dx[i],col+dy[i],res,str+ch);
    board[row][col] = ch;
}

function canWalk(arr,row,col){
    return (row >= 0 && row < arr.length && col >=0 && col < arr[0].length && arr[row][col] != '');
}

class Tride {
    constructor(){
        this.end_word = false;
        this.nexts = new Map();
    }

    insert(words){
        let curr = this;

        for(let word of words) {
            if(!curr.nexts.has(word)) {
                curr.nexts.set(word,new Tride());
            }

            curr = curr.nexts.get(word);
        }

        curr.end_word = true;
    }
}
