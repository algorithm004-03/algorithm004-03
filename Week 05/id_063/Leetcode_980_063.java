/*

dp(i,j,k)表示从开始位置，剩余未走的空格集合为全集 转变到 i,j 位置，剩余未走的空格集合为k的状态 的路径总数
目标就是求dp(end_i, end_j, 空集)


dp(i, j, k) = dp (i-1, j, (k 并 (i,j))) +
              dp (i+1, j, (k 并 (i,j))) +
              dp (i, j-1, (k 并 (i,j))) +
              dp (i, j+1, (k 并 (i,j)))

如果(i, j) 就在k 集合中，这样的状态不存在，dp(i,j,k) = 0;
同样(i, j) 位置如果是障碍物，这样的状态也不存在，dp(i, j, k) = 0;
(i, j)位置不合法，状态也不存在，同样dp(i, j, k) = 0

因为第三维k 的递推没有规律，所以只能用记忆化方式进行递归的DP

从终点往起点推状态，冗余计算比较多，速度慢

 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    private int rowLen;
    private int colLen;
    int[][] gridData;
    private Map<Integer, Integer>[][] dp;
    int start_i;
    int start_j;
    int emptyNum;       // 空白的数量

    // 坐标转换成整型数中的一位, 用于集合的表示
    private int pos2bit(int i, int j) {
        return (1 << (i * colLen + j));
    }

    // 判断位置是否在集合中
    private boolean isInSet(int i, int j, int setVal) {
        return ((setVal & pos2bit(i, j)) != 0);
    }

    // 位置是否有效
    private boolean isPosValid(int i, int j) {
        return (i >= 0) && (i < rowLen) && (j >= 0) && (j < colLen);
    }

    int getPathNum(int i, int j, int setVal) {
        //System.out.println(i + ", " + j + ", " + Integer.toBinaryString(setVal));

        if (!isPosValid(i, j)) {
            return 0;
        }

        if (isInSet(i, j, setVal)) {
            return 0;
        }

        if (gridData[i][j] == -1) {
            return 0;
        }

        if ((i == start_i) && (j == start_j)) {
            int cnt = 0;
            while (setVal != 0) {
                cnt++;
                setVal &= (setVal - 1);
            }
            return cnt == emptyNum+1 ? 1 : 0;
        }

        if ((dp[i][j] != null) && (dp[i][j].containsKey(setVal))) {
            return dp[i][j].get(setVal);
        }

        if (dp[i][j] == null) {
            dp[i][j] = new HashMap<>();
        }

        int bitVal = pos2bit(i, j);
        int sum = 0;

        if (!isInSet(i-1, j, setVal)) {
            sum += getPathNum(i-1, j, setVal | bitVal);
        }

        if (!isInSet(i+1, j, setVal)) {
            sum += getPathNum(i+1, j, setVal | bitVal);
        }

        if (!isInSet(i, j-1, setVal)) {
            sum += getPathNum(i, j-1, setVal | bitVal);
        }

        if (!isInSet(i, j+1, setVal)) {
            sum += getPathNum(i, j+1, setVal | bitVal);
        }

        dp[i][j].put(setVal, sum);
        return sum;
    }

    public int uniquePathsIII(int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;
        gridData = grid;
        dp = new Map[rowLen][colLen];

        int end_i = 0, end_j = 0;
        emptyNum = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                } else if (grid[i][j] == 2) {
                    end_i = i;
                    end_j = j;
                } else if (grid[i][j] == 0) {
                    emptyNum++;
                }
            }
        }

        return getPathNum(end_i, end_j, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsIII(new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        }));
    }
}
