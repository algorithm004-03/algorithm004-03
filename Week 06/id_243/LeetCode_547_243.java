/**
 * @author eazonshaw
 * @date 2019/11/27  16:53
 *
 * 题目：547.朋友圈
 */
public class LeetCode_547_243 {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i != j && M[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int getCount(){
            return count;
        }
    }

}
