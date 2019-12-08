bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
    printf("%d",matrixSize);
    for(int i=0; i<matrixSize; i++){
        for(int j=0; j<matrixColSize[0]; j++){
            if(matrix[i][j]==target)
                return true;
            
        }
    }
    return false;

}