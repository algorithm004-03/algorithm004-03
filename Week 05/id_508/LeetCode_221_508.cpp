class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int max_area=0;
        vector<int> dp;
        for (int i=0;i<matrix.size();++i) {
            int prev = 0;
            for(int j = 0;j<matrix[0].size();++j) {
                if(!i) dp.push_back(matrix[i][j]-'0');
                if(!j) {
                    prev = dp[j];
                    dp[j] = matrix[i][j]-'0';
                }
                if(i&&j) {
                int temp = dp[j];
                dp[j] = matrix[i][j]=='1'?
                min(min(dp[j],prev),dp[j-1])+1:0;
                prev = temp;}
                max_area=max_area>dp[j]?max_area:dp[j];

            }
        }
        return pow(max_area,2);
    }
};
