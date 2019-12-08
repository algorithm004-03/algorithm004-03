/**
 * @Date 2019/11/17
 **/
public class LeetCode_72_648 {
    public int minDistance(String word1, String word2) {
      int[][] dp = new int[word1.length()+1][word2.length()+1];
      for(int i=1;i<=word1.length();i++){
          dp[i][0]=i;
      }
        for(int i=1;i<=word2.length();i++){
            dp[0][i]=i;
        }
     for(int i=1;i<=word1.length();i++){
         for(int j=1;j<=word2.length();j++){
             if(word1.charAt(i-1)==word2.charAt(j-1)){
                 dp[i][j] = dp[i-1][j-1];
             }else {
                 dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
             }
         }
     }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        LeetCode_72_648 leetCode_72_648 = new LeetCode_72_648();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(leetCode_72_648.minDistance(word1,word2));
    }
}
