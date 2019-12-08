/*
DP算法解决
    dp[i] 表示所有能够到下标为i的位置的可能上一跳的跳数的集合
    dp[i] 依赖于dp[i-1], dp[i-2] .... 只要j位置有可能跳到i, 计算出dp[j]的时候
    dp[i] 的值就可以被更新，因此如果从左到右进行迭代，当前如果迭代位置是i, 所有
    dp[i-1], dp[i-2]..... 等计算时候，dp[i]的值就已经被更新完了，不需要计算，但是
    dp[i]需要更新dp[i+1], dp[i+2] ..... 的数值
    到最后，只需要看dp[stones.length - 1] 是不是空集就行了
*/


import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 1) {
            return true;
        }

        if (!((stones[0] == 0) && (stones[1] == 1))) {
            return false;
        }

        List<Integer>[] dp = new List[stones.length];
        Map<Integer, Integer> pos2idx = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            dp[i] = new ArrayList<Integer>();
        }

        Set<Integer> stonePos = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            stonePos.add(stones[i]);
            pos2idx.put(stones[i], i);
        }

        dp[1].add(1);
        for (int i = 0; i < stones.length - 1; i++) {
            Set<Integer> steps = new HashSet<>();
            for (int step : dp[i]) {
                if (step - 1 > 0) {
                    steps.add(step - 1);
                }
                steps.add(step + 1);
                steps.add(step);
            }

            for (int step : steps) {
                if (stonePos.contains(stones[i] + step)) {
                    dp[pos2idx.get(stones[i] + step)].add(step);
                }
            }
        }

        return !(dp[stones.length-1].isEmpty());
    }
}
