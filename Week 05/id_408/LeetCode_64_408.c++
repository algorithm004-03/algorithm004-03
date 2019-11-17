class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) 
    {
        int rows=grid.size();
        if(rows==0)
            return 0;
        int cols=grid[0].size();
        if(cols==0)
            return 0;
        int* opt=new int[cols];
        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<cols;++j)
            {
                int left=INT_MAX;
                int up=INT_MAX;
                if(i>0)
                    up=opt[j];
                if(j>0)
                    left=opt[j-1];
                if(i==0&&j==0)
                    opt[j]=grid[i][j];
                else
                    opt[j]=min(left,up)+grid[i][j];
            }
        }
        int ans=opt[cols-1];
        delete []opt;
        return ans;
    }
};

