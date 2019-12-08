package test1.Week6;

public class LeetCode_547_638 {

    public int findCircleNum(int[][] M) {
        int count = M.length;
        UnionFind unionFind = new UnionFind(count);
        for (int i = 0;i < count - 1;i++){
            for (int j = i + 1;j < count;j++){
                if (M[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count;
    }



    public class UnionFind{

        private int count;
        private int[] p;
        public UnionFind(int count) {
            this.p = new int[count];
            this.count = count;
            for (int i = 0;i < count;i++){
                p[i] = i;
            }
        }

        public int findRoot(int i){
            while (p[i] != i){
                p[i] = p[p[i]];
                i = p[i];
            }
            return p[i];
        }

        public void union(int m,int n){
            int rootM= findRoot(m);
            int rootN= findRoot(n);
            if (rootM == rootN) return;
            p[rootN] = rootM;
            count--;
        }
    }
}
