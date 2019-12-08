var updateBoard = function(board, click) {
	    let [x,y] = click;
	    if(board[x][y] == "M"){
	        board[x][y] = 'X';
	        return board;
	    }
	    function dfs(board,x,y){
	        let num =  getNum(board,x,y);
	        if(num == 0){
	            board[x][y] = 'B';
	        } else {
	            board[x][y] = num+'';
	            return board
	        }
	        for(let i = -1; i <= 1; i++){
	            for(let j = -1; j <= 1; j++){
	                if(x+i >= 0 && x+i < board.length && 
	                    y+j >= 0 && y<board[0].length && 
	                    board[x+i][y+j] == 'E'){
	                    board = dfs(board, x + i, y + j);
	                }
	            }
	        }
	        return board;
	    }
	    function getNum(board,x,y){
	        let num = 0;
	        for(let i = -1; i <= 1; i++){
	            for(let j = -1; j <= 1; j++){
	                if(x+i >= 0 && x+i < board.length && 
	                   y+j >= 0 && y<board[x].length && 
	                   board[x+i][y+j] == 'M'){
	                    num++
	                }
	            }
	        }
	        return num;
	    }
	
	    return dfs(board, x, y);

};