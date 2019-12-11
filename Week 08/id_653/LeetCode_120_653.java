class Solution {
    int row;
    Integer[][]memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row+1];

        for (int level = row-1; level >=0 ; level--) {
            for (int i = 0; i <= level; i++) {
                dp[i] = triangle.get(level).get(i) + Math.min(dp[i],dp[i+1]);
            }
        }

        return dp[0];
    }

    public int dfs(int level,int position,List<List<Integer>> triangle) {
        if(memo[level][position]!=null) {
            return memo[level][position];
        }

        if(level==row-1) {
            return memo[level][position]=triangle.get(level).get(position);
        }

        int left = dfs(level+1,position,triangle);
        int right = dfs(level+1,position+1,triangle);

        return memo[level][position] = Math.min(left,right) + triangle.get(level).get(position);
    }
}