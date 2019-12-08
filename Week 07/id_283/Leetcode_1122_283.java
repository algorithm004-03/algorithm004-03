/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = arr1[0], min = arr1[0];
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] > max){
                max = arr1[i];
            }
            if (arr1[i] < min){
                min = arr1[i];
            }
        }
        int [] arr1new = new int [max-min+1];
        for (int i = 0; i < arr1.length; i++){
            arr1new[arr1[i] - min]++; 
        }
        int [] ans = new int [arr1.length];int p = 0;
        for (int i = 0; i < arr2.length; i++){
            while(arr1new[arr2[i] - min] > 0){
                ans[p++] = arr2[i] ;
                arr1new[arr2[i] - min]--;
            }
        }
        for (int i = 0; i < arr1new.length; i++){
            while (arr1new[i] > 0){
                ans[p++] = i + min;
                arr1new[i] --;
            }
        }
        return ans;
    }
}
// @lc code=end

