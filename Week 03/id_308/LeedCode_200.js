/**
 * 题目： 岛屿数量
 * 语言： JavaScript
 * 执行结果： 打败了93%的用户
 * 方法：深度优先遍历
 * */


/**
 * @param {character[][]} grid
 * @return {number}
 */
const numIslands = function(grid) {
    const dy = grid.length;
    if(!dy) return 0;

    const dx = grid[0].length;
    let count = 0;

    for(let j = 0; j < dy;j++) {
        for(let i = 0; i < dx;i++) {
            if(~~grid[j][i] === 1) {
                count++;
                chooseLand(j,i);
            }
        }
    }

    function chooseLand(y,x) {
        const sx = [-1,1,0,0];
        const sy = [0,0,-1,1];

        if(~~grid[y][x] === 1) {
            grid[y][x] = "0";

            for(let count = 0; count < 4; count++){
                const tempY = sy[count]+y;
                const tempX = sx[count]+x;

                if(tempY >= 0 && tempY < dy && tempX >= 0 && tempX < dx && ~~grid[tempY][tempX] === 1) {
                    chooseLand(tempY,tempX);
                };
            }
        }
    }

    return count;
};
