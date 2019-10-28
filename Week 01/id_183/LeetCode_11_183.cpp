/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        //pointer i: from front;
        //pointer j: from rear;
        int i,j;
        int res =0 ;
        for(i = 0, j=height.size()-1;i<j;)
        {
            //always move the smaller bar
            int minheig[  ]t = height[i]<height[j]?height[i++]:height[j--];
            res = max(res,minheight*(j-i+1));
           
        }
         return res;
    }
};
// @lc code=end

