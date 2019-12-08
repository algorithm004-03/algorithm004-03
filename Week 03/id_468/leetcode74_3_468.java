package week3;

/**
 * @program: leetcode
 * @description: 搜索二维矩阵
 * @author: 王瑞全
 * @create: 2019-11-0323:19
 **/


public class leetcode74_3_468 {
    public boolean searchMatrix(int[][] matrix, int target) {
       for(int[] index:matrix){
           if(index.length==0){
               return false;
           }
           if(index[index.length-1]<target){
               continue;
           }
           for(int i=index.length-1;i>=0;i--){
               if(index[i]==target){i--;return true;}
           }
       }
       return false;
    }
}
