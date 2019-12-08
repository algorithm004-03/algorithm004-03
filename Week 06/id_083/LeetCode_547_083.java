import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(final int[][] M) {

        
        final int[] visited = new int[M.length];
        int count = 0;

        // 20191119 DFS时间复杂度O(n^2)
        for(int i=0;i<M.length;i++){
            if(visited[i] == 0){
                dfs(M,visited,i);
                count++;
            }
        }


        // // 20191119 BFS时间复杂度O(n^2)
        // Queue<Integer> queue = new LinkedList<>();
        // for(int i=0;i<M.length;i++){
        //     if(visited[i] == 0){
        //         queue.add(i);
        //         while(!queue.isEmpty()){
        //             int s = queue.remove();
        //             visited[s] = 1;
        //             for(int j=0;j<M.length;j++){
        //                 if(M[s][j] == 1 && visited[j] == 0)
        //                 queue.add(j);
        //             }
        //         }
        //         count++;
        //     }
        // }

        return count;
    }

    public void dfs(int [][]M,int []visited,int i){
        for(int j=0;j<M.length;j++){
            if(M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
// @lc code=end

