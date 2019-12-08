package leetcode.week6;

/**
 * 并查集实现
 * @author eason.feng at 2019/11/20/0020 19:38
 **/
public class UnionFindTemplate {

    private int count = 0;

    private int[] parent;

    public UnionFindTemplate(int n) {
        count = n;
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
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
