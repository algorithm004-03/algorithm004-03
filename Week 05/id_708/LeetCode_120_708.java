class Solution {
    // 分治：当前位置最小值 = 左子树和右子树最小值 + 当前位置值
    // 所以自底向上为：计算左子树和右子树最小值+当前位置值
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1]; // 最大行数量总等于行数
        for (int i = triangle.size()-1; i >= 0; i--) { // 自底向上
            for (int j = 0; j < triangle.get(i).size(); j++) { // 从左往右遍历
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}