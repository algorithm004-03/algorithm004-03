class Solution {
public:
    void update( vector< vector< vector<int>>>& record, int begin_i, int begin_j){
        int line_min = record[begin_i][begin_j][0];
        int row = record[begin_i][begin_j][1];
        
        for( int count = 0; count < row; count++){
            line_min = min( line_min, record[ begin_i-count][begin_j][0]);
            record[begin_i][begin_j][2] = max( record[begin_i][begin_j][2], line_min * (count + 1));
        }
    }
    
    int maximalRectangle(vector<vector<char>>& matrix) {
        if( !matrix.size())
            return 0;
        vector< vector< vector<int>>> record( matrix.size(), vector<vector<int>>( matrix[0].size(), {0,0,0}));
        int res = 0;
        //dp 过程
        for( int i = 0; i < matrix.size(); i++)
            for( int j = 0; j < matrix[0].size(); j++){
                if( matrix[i][j] == '0')
                    ;
                else
                    if( i == 0 && j == 0)
                        record[i][j] = { 1, 1, 1};                
                    else if( i == 0)
                        record[i][j] = {record[i][j-1][0] + 1, 1, record[i][j-1][2] + 1};
                    else if( j == 0)
                        record[i][j] = {1, record[i-1][j][1] + 1, record[i-1][j][2] + 1};
                    else{
                        record[i][j][0] = record[i][j-1][0] + 1, record[i][j][1] = record[i-1][j][1] + 1;
                        update( record, i, j);
                    }
                res = max( res, record[i][j][2]);
            }
            
        return res;
    }
};
