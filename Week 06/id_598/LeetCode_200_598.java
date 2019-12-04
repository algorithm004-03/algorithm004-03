/**
 * 岛屿数量
 *
 * @author northleaf
 * @create 2019年11月20日
 */
public class LeetCode_200_598 {
    /**
     * 并查集的方法
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {


        if (grid == null || grid.length < 1) {
            return 0;
        }

        UnionField unionField = new UnionField(grid);
        //二维数组遍历
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == '1'){
                    //此步的目的是为了路径压缩
                    grid[i][j] = '0';
                    if(i - 1 >= 0 && grid[i-1][j] == '1'){
                        unionField.union(i*c +j ,(i -1 )* c +j );
                    }
                    if(i+1 < r && grid[i+1][j] == '1' ){
                        unionField.union(i*c +j ,(i+1) * c +j );
                    }
                    if(j -1 >= 0 && grid[i][j-1] == '1'){
                        unionField.union(i*c + j ,i*c +j -1);
                    }
                    if(j +1 < c && grid[i][j+1] == '1'){
                        unionField.union(i*c + j ,i*c +j +1);
                    }
                }
            }
        }

        return unionField.getSize();
    }


    class UnionField {
        int count = 0;

        int[] parent = null;

        /**
         * 通过二维数组构造并查集
         *
         * @param grid 二维方阵
         */
        public UnionField(char[][] grid) {
            //行数
            int r = grid.length;
            //列数
            int c = grid[0].length;
            //构造数组
            parent = new int[r * c];
            //初始化时，只是交界处为1，才能数量加1
            for(int i  = 0;i<r;i++){
                for(int j = 0;j<c;j++){
                    if(grid[i][j] == '1') {
                        parent[i * c + j] = i*c+j;
                        count++;
                    }
                }
            }
        }


        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int proot = find(p);
            int qroot = find(q);
            if (qroot == proot) return;

            parent[qroot] = proot;

            count--;
        }

        public int getSize() {
            return count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        LeetCode_200_598 leetCode_200_598 = new LeetCode_200_598();
        System.out.println(leetCode_200_598.numIslands(grid));
    }

    /**
     * dfs的方式
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {


        if (grid == null || grid.length < 1) {
            return 0;
        }
        int numsOfIslands = 0 ;
        //二维数组遍历
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == '1'){
                    //岛屿数量加1
                    numsOfIslands++;
                    dfs(grid,i,j,r,c);
                }
            }
        }

        return numsOfIslands;
    }

    /**
     * 深度递归遍历
     * @param grid
     * @param i
     * @param j
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int i, int j, int r, int c) {
        //终止条件
        if(i<0 || j < 0 || i>=r||j>=c||grid[i][j] == '0'){
            return;
        }
        //当前层处理
        //将1变为0
        grid[i][j] = '0';
        //处理四连通
        dfs(grid,i+1,j,r,c);
        dfs(grid,i-1,j,r,c);
        dfs(grid,i,j+1,r,c);
        dfs(grid,i,j-1,r,c);

    }

}
