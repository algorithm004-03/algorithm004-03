package problem403.Solution1;


/*
树形DP求解

设dp(i, j) 表示从某位置跳跃j步到达位置为i的位置是否可能

dp(i, j) 对于一系列其他的dp状态呈树形依赖关系
dp(i, j) = dp(i-j, j-1) || dp(i-j, j+1) || dp(i-j, j)

如果i是不存在的位置，dp(i, j)为false

basecase 如下
i是第一个位置情况下，dp(i, 0) = true , 对于其余j dp(i, j) = false
i位置是第二个石头位置，j只能为1

递归进行树型的递推，basecase是回溯的方式
速度稍慢，有迭代式的DP解法

 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    private Map<Long, Boolean> cache;
    private Set<Integer> stonePos;
    private int firstStone;
    private int secondStone;

    private long getKey(int i, int j) {
        return (((long)(i)) << 32) + j;
    }

    private boolean isValid(int i, int j) {
        //System.out.println(i + ", " + j);
        if (!stonePos.contains(i)) {
            return false;
        }

        if (i == firstStone) {
            return j == 0;
        }

        if (i == secondStone) {
            return j == 1;
        }

        if (j <= 0) {
            return false;
        }

        long key = getKey(i, j);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean result = isValid(i - j, j - 1) || isValid(i - j, j) || isValid(i - j, j + 1);
        cache.put(key, result);

        return result;
    }

    public boolean canCross(int[] stones) {
        if (stones.length == 1) {
            return true;
        }

        if (!((stones[0] == 0) && (stones[1] == 1))) {
            return false;
        }

        cache = new HashMap<>();
        stonePos = new HashSet<>();

        firstStone = stones[0];
        secondStone = stones[1];

        for (int pos : stones) {
            stonePos.add(pos);
        }

        int lastPos = stones[stones.length - 1];
        for (int pos : stones) {
            if (isValid(lastPos, lastPos - pos)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0,1,3,4,5,7,9,10,12}));
    }
}


