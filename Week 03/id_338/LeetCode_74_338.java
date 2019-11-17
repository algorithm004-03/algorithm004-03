/**
 * Created by leesen on 2019/10/31.
 */
public class LeetCode_74_338 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        if (colNum == 0) return false;  //****[[]]
        for (int i=0; i<rowNum; i++) {
            //找到匹配行
            if (target > matrix[i][colNum-1]) continue;

            //暴力法  ****j<matrix[i].length
            for (int j=0; j<colNum; j++) {
                if (target == matrix[i][j]) return true;
            }
            return false;  //****匹配行找不到则中断查找

            //二分查找
//            int left = 0;
//            int right = colNum - 1;
//            while (left <= right) {  //**** <= 否则长度为1的会漏掉
//                int mid = left + (right - left) / 2;
//                if (target == matrix[i][mid]) return true;
//                else if (target > matrix[i][mid]) left = mid + 1;
//                else right = mid - 1;
//            }
        }

        //上面两种解法的问题是,当二维数组为n*1列的时候时间复杂度退化为O(n*m)
        //可以将二维数组当成一维单调直接二叉处理
        //但是rowNum * colNum可能溢出, / %这些也很耗时,反而不如上面速度快
        int begin = 0, end = rowNum * colNum - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (matrix[mid/colNum][mid%colNum] == target) return true; //****此处求值技巧是关键,都是跟colNum做运算
            else if (matrix[mid/colNum][mid%colNum] < target) begin = mid + 1;
            else end = mid - 1;
        }

        //综上所述, 实际的工程中要看具体的二维数组是什么类型的
        //如果n*m都不大, 选1即可
        //如果n不大,m很大, 选2
        //如果n和m都很大, 选3

        return false;
    }

    //***终极推荐, 国际版简洁写法, while循环, 并简化指针判断
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
