/*
 * 85. 最大矩形
 */

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        if(rows == 0) return 0;
        int cols = matrix[0].size();

        int maxArea = 0;
        
        vector<int> height(cols, 0);
        vector<int> left(cols, 0);
        vector<int> right(cols, cols);

        for(int i=0; i<rows; ++i) {
            int curLeft=0, curRight=cols;

            for(int j=0; j<cols; ++j) {
                height[j] = (matrix[i][j]=='1') ? height[j]+1 : 0;
            }
            for(int j=0; j<cols; ++j) {
                if(matrix[i][j] == '1')
                    left[j] = max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j+1;
                }
            }
            for(int j=cols-1; j>=0; --j) {
                if(matrix[i][j] == '1')
                    right[j] = min(right[j], curRight);
                else {
                    right[j] = cols;
                    curRight = j;
                }
            }

            for(int j=0; j<cols; ++j) {
                maxArea = max(maxArea, height[j]*(right[j]-left[j]));
            }
        }

        return maxArea;
    }
};