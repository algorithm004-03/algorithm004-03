/*
 * @lc app=leetcode id=88 lang=cpp
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        //sort from the  largest element and store it in num1
        int pos = m+n-1;
        while(n>0)//while num2 still has elements ready to be traverse
        {
            //start from the rightmost 
            if(m>0 && nums1[m-1]>nums2[n-1])
            {
                nums1[pos--] = nums1[--m];
            }else{
                nums1[pos--] = nums2[--n];
            }
        }
    }
};
// @lc code=end

