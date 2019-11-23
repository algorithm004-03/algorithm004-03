class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = 0;
        if(rows>0) cols = matrix[0].size();
        int left = 0,right = cols -1;
        int up = 0, bottom = rows -1;
        int mid_row, mid_cols;
        cout<<up<<" "<<bottom<<endl;
        cout<<left<<" "<<right<<endl;
        while(up<=bottom) {
            mid_row = up + (bottom - up)/2;
            if(up == bottom) break;
            if(matrix[mid_row][0]<=target&&matrix[mid_row][cols-1]>=target) {
                break;
            }
            if(matrix[mid_row][0]>target) {
                bottom = mid_row -1;
            } else {
                up = mid_row + 1;
            }
        }
        bool res = false;

        while(left<=right) {
            mid_cols = left + (right - left)/2;
            if(matrix[mid_row][mid_cols]== target) {
                res = true;
                break;
            }
            if(matrix[mid_row][mid_cols]>target) {
                right = mid_cols -1;
            } else {
                left = mid_cols + 1;
            }
        }
        return res;
    }
};
