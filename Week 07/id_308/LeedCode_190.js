/**
 * 题目： 颠倒二进制位
 * 语言： JavaScript
 * 执行结果： 打败了25.38%的用户
 * */


/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
const solveNQueens = function(n){
    let answers = [],
        uppeeerlim = (1<<n)-1,
        queens = [];


    function addSolution() {

    }

    function backtrack(col,ld,rd) {
        if(col === uppeeerlim) addSolution()
        else {
            let pos = uppeeerlim &- (col | ld | rd);
            while (pos) {
                let current = pos &(~pos+1);
                pos -= current;
                queens.push(n-1-Math.log2(current));

                backtrack(col | current,uppeeerlim & (ld|current) >> 1,uppeeerlim & (rd | current) << 1);
                queens.pop();
            }
        }
    }

    backtrack(0, 0, 0);
    return answers;
};
