/**
 * @author Leesen
 * @date 2019/11/24 22:38
 */
public class LeetCode_547_338 {
    //并查集
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n; //****容易遗漏
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                // path compression by halving
                // 巧妙, 跳过中间一个节点,
                // 可以用1,2,3相连的画图试试,当p!=parent[1]时,直接跳到判断3=parent[3]
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            //使用rank可以压缩路径长度, 如果不rank,此处可简单处理为 parent[rootP] = rootQ
            if (rank[rootQ] > rank[rootP]) {  //****rank[rootQ]
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }

            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        //step1. 并查集初始化
        UnionFind uf = new UnionFind(n);
        //step2. 并查集合并
        for (int i = 0; i < n - 1; i++) {  //***n-1
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        //step3. 并查集计数
        return uf.count();
    }
}
