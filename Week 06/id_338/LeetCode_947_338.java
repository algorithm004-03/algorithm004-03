/**
 * @author Leesen
 * @date 2019/11/24 22:39
 */
public class LeetCode_947_338 {
    // If stone a and stone b are in the same column/row, we connect them as a component
    // One component can be removed to one stone left at least.
    // The largest possible number of moves we can make = Total stones count - count of stones left = Total stones count - count of components.
    public int removeStones(int[][] stones) {
        int count = 0;
        int n = stones.length;
        //初始化并查集
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        //合并操作
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  //****此处细节条件不同
                // check if either row or column is same
                // If yes then connect them
                // 其它都类似,关键点在这里
                if (stones[i][0] == stones[j][0] ||  //横坐标行合并
                        stones[i][1] == stones[j][1]) {  //纵坐标列合并
                    int u = find(parent, i);
                    int v = find(parent, j);
                    if (u == v) continue;
                    parent[u] = v;
                }
            }
        }

        // 求出总数。these are the ones that did not connect means clusters count
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) count++;
        }

        return n - count;
    }

    private int find(int[] parent, int v) {
        return parent[v] == v ? v : find(parent, parent[parent[v]]);
    }

}
