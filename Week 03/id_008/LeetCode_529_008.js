/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    open(click[0], click[1]);
    return board;

    function open(x, y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (board[x][y] === "M") {
            board[x][y] = "X";
        }
        else if (board[x][y] === "E") {
            var total = count(x, y);

            if (total) {
                board[x][y] = "" + total;
            }
            else {
                board[x][y] = "B";
                open(x - 1, y - 1);
                open(x    , y - 1);
                open(x + 1, y - 1);
                open(x - 1, y    );
                open(x + 1, y    );
                open(x - 1, y + 1);
                open(x    , y + 1);
                open(x + 1, y + 1);
            }
        }

        return false;
    }

    function count(x, y){
        var total = 0;
        try { if (board[x - 1][y - 1] === "M") ++total; } catch (e){}
        try { if (board[x    ][y - 1] === "M") ++total; } catch (e){}
        try { if (board[x + 1][y - 1] === "M") ++total; } catch (e){}
        try { if (board[x - 1][y    ] === "M") ++total; } catch (e){}
        try { if (board[x + 1][y    ] === "M") ++total; } catch (e){}
        try { if (board[x - 1][y + 1] === "M") ++total; } catch (e){}
        try { if (board[x    ][y + 1] === "M") ++total; } catch (e){}
        try { if (board[x + 1][y + 1] === "M") ++total; } catch (e){}
        return total;
    }
};
