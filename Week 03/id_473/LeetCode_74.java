import java.util.ArrayList;
import java.util.List;
/**
 * 74. 搜索二维矩阵
 * @Author CJ
 * @create 2019/11/3
 */
class LeetCode_74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5}};
        //int[][] matrix = new int[][]{{},{1}};
        int target = 1;
        System.out.println(searchMatrix(matrix, target));
    }

    //二分查找（二维数组转一维数组）
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null) {
            return false;
        }

        Integer[] nums = toOne(matrix);
        if (nums.length == 0 || nums == null){
            return  false;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (left + right)>>>1;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[left] <= target && target <= nums[mid]){
                right = mid;
            }else {
                left = mid;
            }
        }
        if (nums[left] == target || nums[right] == target){
            return true;
        }
        return  false;
    }
    //二维数组转一维数组
    private static Integer[] toOne(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i,j = 0;
        for ( i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0){
                continue;
            }
            for ( j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        return  list.toArray(new Integer[list.size()]);
    }

}