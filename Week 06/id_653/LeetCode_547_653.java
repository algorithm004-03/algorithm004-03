class Solution {

    public int findCircleNum(int[][] M) {
        int len =M.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j]==1) {
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind{

        private int [] rank;

        public int getCount() {
            return count;
        }

        private int count;
        private int [] parent;

        private int findP(int p) {
            while (parent[p]!=p) {
                p = parent[p]=parent[parent[p]];
            }
            return p;
        }

        public UnionFind(int count) {
            this.count = count;
            parent = new int[count];
            rank = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }

        public void union(int p, int q) {
            int pRoot = findP(p);
            int qRoot = findP(q);
            if (pRoot==qRoot) {
                return;
            }
            if (rank[pRoot]>rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else  if (rank[qRoot]>rank[pRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[p]++;
            }
            count--;
        }


        public int findCircleNum(int[][] M) {
            int len =M.length;
            UnionFind unionFind = new UnionFind(len);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j]==1) {
                        unionFind.union(i,j);
                    }
                }
            }
            return unionFind.getCount();
        }
    }
}