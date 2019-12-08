public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        if(rowCount == 0 || matrix[0].length == 0) return false;
        int top = 0 ;
        int bottom = rowCount - 1;
        int mid = 0 ;
        if(rowCount > 1){
            while( top < bottom){
                mid = (top + bottom) /2;
                if(matrix[mid][0] == target){
                 return true;
                }else if(matrix[mid][0] < target){
                    top = mid + 1;
                }else {
                    bottom = mid - 1;
                }
            }
        
            if(matrix[top][0] > target ) top--;

            if(top < 0){
                return false;
            }

        }
        int left = 0 ;
        int right = matrix[top].length - 1;
        mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(matrix[top][mid] == target){
                return true;
            }else if(matrix[top][mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}