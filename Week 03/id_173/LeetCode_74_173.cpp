/*
 * 74. 搜索二维矩阵
 */
 
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty())
            return false;
        
        int rows = matrix.size(), cols = matrix[0].size();
        int left = 0, right = rows*cols-1;

        while(left <= right) {
            int mid = left+(right-left)/2;
            int num = matrix[mid/cols][mid%cols];
            if(num == target)
                return true;
            else if(num < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
};