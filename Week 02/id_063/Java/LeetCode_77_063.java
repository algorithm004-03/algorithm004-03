/*
思路

递归算法练习

进行1层到n层的递归，每一层递归选择当前层对应的数字是否选择，当选择是的层数总和达到k时候生成一个结果并且进行回溯
 */



public class Solution {

    private List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> curChoice, int maxChoiceNum, int curLevel, int maxLevel) {
        if (curChoice.size() == maxChoiceNum) {
            result.add(new ArrayList<Integer>(curChoice));
            return result;
        }

        if (curLevel > maxLevel) {
            return result;
        }

        if ((maxLevel - curLevel + 1) + curChoice.size() < maxChoiceNum) {
            // 剪枝操作，就算剩下所有的数字全部选择也凑不齐maxChoiceNum个数字，直接回溯
            return result;
        }

        // 当前层数据不选择
        dfs(result, curChoice, maxChoiceNum, curLevel+1, maxLevel);

        // 当前层数据选择
        curChoice.add(curLevel);
        dfs(result, curChoice, maxChoiceNum, curLevel+1, maxLevel);
        curChoice.remove(curChoice.size() - 1);     // 恢复现场

        return result;
    }

    // 计算组合数
    private int getComposeNum(int n, int k) {
        if (k > n - k) {
            k = n-k;
        }

        int totalNum = 1;
        for (int i = 0; i < k; i++) {
            totalNum *= n - i;
        }

        for (int i = 0; i < k; i++) {
            totalNum /= k;
        }

        return totalNum;
    }

    public List<List<Integer>> combine(int n, int k) {
        return dfs(new ArrayList<List<Integer>>(getComposeNum(n, k)), new ArrayList<Integer>(k), k, 1, n);
    }
}