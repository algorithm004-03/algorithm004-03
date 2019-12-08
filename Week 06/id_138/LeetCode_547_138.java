import java.util.LinkedList;
import java.util.Queue;

/**
 *
朋友圈：
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * @author L
 *
 */
public class LeetCode_547_138 {
	/**
	 * 
	 * @param M
	 * @return
	 */
	public int findCircleNum(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		int length = M.length;
		for(int i=0;i<length;i++) {
			if(visited[i] == 0) {
				dfs(M, visited, i);
				count++;
			}
		}
		return count;
	}
	/**
	 * dfs：深度优先，给定的矩阵可以看成图的邻接矩阵。这样我们的问题可以变成无向图连通块的个数
	 * @param m
	 * @param visited
	 * @param i
	 */
	private void dfs(int[][] m, int[] visited, int i) {
		// TODO Auto-generated method stub
		for(int k=0;k<m.length;k++) {
			if(m[i][k] == 1 && visited[k] == 0) {
				visited[k] = 1;
				dfs(m,visited,k);
			}
		}
	}
	
	/**
	 * 广度优先:我们从任一个节点开始广搜，使用 visitedvisited 数组记录是否被访问过。增加 countcount 变量当一个连通块已经访问完但是还有节点没有被访问的时候。
	 * @param M
	 * @return
	 */
	public int findCircleNum_2(int[][] M) {
		int visited[] = new int[M.length];
		int count = 0;
		Queue<Integer>queue = new LinkedList<Integer>();
		for(int i=0;i<M.length;i++) {
			if(visited[i] == 0) {
				queue.add(i);
				while(!queue.isEmpty()) {
					int k = queue.remove();
					visited[k] = 1;
					for(int j=0;j<M.length;j++) {
						if(M[k][j]==1 && visited[j] == 0) {
							queue.add(j);
						}
					}
				}
				count++;
			}
		}
		return count;		
	}
}
