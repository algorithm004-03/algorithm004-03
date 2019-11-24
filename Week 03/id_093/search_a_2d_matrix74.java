class search_a_2d_matrix74{

    public static boolean search_a_2d_matrix74(int[][] matrix, int target){
        //第一步，处理空集或者null的特殊情况
        if (matrix == null || matrix.length ==0) return false;
        //定义矩阵的行列和左右指针
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        //当首末指针不相交时，执行下列程序（整个和二分法模板很像，主要是行列，还有矩阵中mid所在点的处理）
        while (left <= right){
            int mid = (left + right) / 2;
            //除以列可以得到行数m1，除以列求余可以列数n1。
            int position = matrix[mid/n][mid%n];
            if (target == position) return true;
            else if (position > target) right = mid - 1;
                 if (position < target) left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix1= {{1,2,3},{4,5,6},{9,10,11}};
        int target1 = 7;
        System.out.println(search_a_2d_matrix74(matrix1,target1));
    }

}
