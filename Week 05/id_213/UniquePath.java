class Solution{
//思路：采用自底向上的思路，最后一步可由两步完成。有该位置的上方位和左方位完成。
//某位置的到达方式可以有该位置的右位置和下位置的求和得到。
//采用自底向上的方式时默认最后一行，最后一列只有一种方式。
    public int uniquePath(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }

}