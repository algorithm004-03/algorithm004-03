class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for(int i =triangle.size()-1 ; i>=0 ; i--){
            for(int j=0 ; j<triangle.get(i).size() ; j++){
                dp[j] =Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
//class Solution {
//     int row;    
//     Integer[][] memo;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         row = triangle.size();
//         memo = new Integer[row][row];
//         return helper(0,0,triangle);
//     }
//     public int helper(int level , int c , List<List<Integer>> triangle){
//         if(memo[level][c] != null) return memo[level][c];
//         if(level == row -1) return memo[level][c]=triangle.get(level).get(c);
//         int left = helper(level+1,c,triangle);
//         int right = helper(level+1,c+1,triangle);
//         return memo[level][c] = Math.min(left,right)+triangle.get(level).get(c);
//     }
// }
