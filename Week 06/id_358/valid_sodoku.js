/**
 * @param {character[][]} board
 * @return {boolean}
 */
 var isValidSudoku = function(board) {
    const rows = {}, columns = {}, boxes = {}
    for(let i = 0; i < 9; i++) {
        for(let j = 0; j < 9; j++) {
            let boxIndex = parseInt(i/3) * 3 + parseInt(j/3)
            let num = board[i][j]
            if(num !== '.') {
                if(rows[i+'-'+num] || columns[j+'-'+num] || boxes[boxIndex + '-' + num]) {
                    return false;
                }
                rows[i+'-'+num] = true;
                columns[j+'-'+num] = true;
                boxes[boxIndex+'-'+num] = true;
            }
        }
    }
    return true;
};