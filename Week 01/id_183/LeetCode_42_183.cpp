/*
 * @lc app=leetcode id=42 lang=cpp
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
public:
    int trap(vector<int>& height) {
            int i,j=0,n=height.size();
            if(!n) return 0;
            vector<int>left(n,0);         // left-max
            vector<int>right(n,0);       // right-max

            left[0]=height[0];
            for(i=1;i<n;i++)
                left[i] = max(height[i], left[i-1]);
            
            right[n-1] = height[n-1];
            for(i=n-2;i>=0;i--)
                right[i] = max(height[i], right[i+1]);
            
            for(i=0;i<n;i++)
                j += min(left[i], right[i]) - height[i];
            
            return j;
    }
};
// @lc code=end

