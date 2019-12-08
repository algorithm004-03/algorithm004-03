class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		//terminal codintion 一维为空边界
        if (matrix.length == 0){
            return false;
        }  
        int low = 0;
        int height = matrix.length - 1;
		//terminal codintion 二维为空边界
        if (matrix[low].length == 0){
            return false;
        }           
		//先用二分法确定一维的位置
        while (low <= height){
            int middle = low + (height - low) / 2;
            int x = 0;
            int y = matrix[middle].length - 1;
            int mid = x + (y - x) / 2;
			//总是要碰下运气的,万一中了呢
            if(matrix[middle][mid] == target){
                return true;
            }
            //先确定一维数组的位置
            if (matrix[middle][y] < target){
                low = middle + 1;
            }else if (matrix[middle][x] > target){
                height = middle - 1;
            }else {
				//确定二维数组的位置
                while (x <= y){
                    mid = x + (y - x) / 2;
					//返回结果
                    if (matrix[middle][mid] == target){
                        return true;
                    }
                    if (matrix[middle][mid] > target){
                        y = mid - 1;
                    }else {
                        x = mid + 1;
                    }
                }
				//这里需要跳出一维的循环
                break;
            }
        }
		//数组内不包含要寻找的元素
        return false;
    }
}
