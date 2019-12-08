/**
 * 岛的数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 */
public class LeetCode_200_648 {
    int[] dx =new int[]{-1,1,0,0};
    int[] dy =new int[]{0,0,-1,1};
    char[][] g;

    /**
     * 方法一 flood fill
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        g = grid;
        int isLand = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
               if(grid[i][j]==0){continue;}
               isLand+=sink(i,j);
            }
        }
        return isLand;
    }

    /**
     * 方法2 深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int isLand = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    isLand++;
                    bfs(grid,i,j);
                }
            }
        }
        return isLand;
    }
    private void bfs(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        bfs(grid,i+1,j);
        bfs(grid,i-1,j);
        bfs(grid,i,j-1);
        bfs(grid,i,j+1);
    }

    private int sink(int i,int j){
        if(g[i][j]=='0'){
            return 0;
        }
        g[i][j]='0';
        for(int k=0;k<dx.length;k++){
            int x = i+dx[k];int y = j+dy[k];
            if(x>=0&&x<g.length&&y>=0&&y<g[0].length){
                if(g[x][y]=='0')continue;
                sink(x,y);
            };
        }
        return 1;
    }


    public  char[][] buildArray (String str){
        String[] strs = str.split("[&]");
        char[][] grid = new char[strs.length][5];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<5;j++){
                grid[i][j]=strs[i].charAt(j);
            }
        }
        printArray(grid);
        return grid;
    }
    public void printArray(char[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("=========================");
    }
    public static void main(String[] args) {
        String str ="11000&11000&00100&00011";
        LeetCode_200_648 leetCode_200_648 = new LeetCode_200_648();
        char[][] grid = leetCode_200_648.buildArray(str);
        int size = leetCode_200_648.numIslands(grid);
        System.out.println(size);
    }


}
