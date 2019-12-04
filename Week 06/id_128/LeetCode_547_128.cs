public class Solution
{

    public int FindCircleNum(int[][] M)
    {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (M[i][j] == 1) uf.Union(i, j);
            }
        }
        return uf.Count();
    }

    class UnionFind
    {
        private int count = 0;
        private int[] parent;
        private int[] rank;

        public UnionFind(int n)
        {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
            {
                parent[i] = i;
            }
        }

        public int Find(int p)
        {
            while (p != parent[p])
            {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void Union(int p, int q)
        {
            int rootP = Find(p);
            int rootQ = Find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP])
            {
                parent[rootP] = rootQ;
            }
            else
            {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ])
                {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int Count()
        {
            return count;
        }
    }


}