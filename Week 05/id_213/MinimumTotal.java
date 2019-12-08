class Solution {
//思路 ：通过从上至下递归，通过比较得到最小值。
//思路 ：由下至上DP，通过level层与level-1层的两者之和取小值存于level层的相应为值。
    public int minimumTotal(List<List<Integer> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }
}