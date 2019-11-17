
var numIslands = function(grid) {
	//上下左右
    const dx = [-1,1,0,0];
    const dy = [0,0,-1,1];
    let g = grid;
    let islands = 0;

    for (let i = 0; i < g.length; i++) {
        for (let j = 0; j < g[i].length; j++) {
            if (g[i][j]=='0') continue;//剪枝
            islands += sink(i,j);        
        }
    }
    return islands;

    function sink(i, j){
        if(g[i][j]=='0') return 0;

        //不为0的话就将该岛变为0
        g[i][j] = '0';

        for (let k = 0; k < dx.length; k++) {
            let x = i + dx[k], y = j + dy[k];
            
            if(x>=0 && x < g.length && y >= 0 && y < g[i].length){
                // console.log('k'+k,x,y,g[x][y]);
                if( g[x][y] == '0') continue;
                
                sink(x,y);
            }
        }
        return 1;
    }
    
};
