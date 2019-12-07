#include <stdbool.h>

bool searchMatrix(int **matrix, int matrixSize, int *matrixColSize, int target) {
    if (!matrixSize) 
        return false;
    int left = 0;
    int right = matrixSize * matrixColSize[0] -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        int x = mid / matrixColSize[0];
        int y = mid - x * matrixColSize[0];
        if (matrix[x][y] == target)
            return true;
        else if (matrix [x][y] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }   
    return false;
}

// bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
//     if(matrixSize==0){
//         return false;
//     }
//     int left=0;
//     int right=matrixSize*matrixColSize[0];
//     while(left<right){
//         int mid=(left+right)/2;
//         int x=mid/matrixColSize[0];
//         int y=mid-x*matrixColSize[0];
//         if(matrix[x][y]==target){
//             return true;
//         }else if(matrix[x][y]<target){
//             left=mid+1;
//         }else{
//             right=mid;
//         }
//     }
//     return false;
// }

