/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //O(1)
        int []cnt = new int[1001];
        //计算每个桶有多少个数
        for(int n:arr1) cnt[n]++;
        int i=0;
        //按arr2顺序依次取出数值
        for(int n:arr2){
            while(cnt[n]-- > 0){
                arr1[i++] = n;
            }
        }
        //没在arr2中的，按升序输出
        for(int n=0;n<cnt.length;n++){
            while(cnt[n]-- > 0){
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
// @lc code=end

