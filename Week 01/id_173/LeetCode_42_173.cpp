/*
 * 42. 接雨水
 */

class Solution {
public:
    int trap(vector<int>& height) {
        int res=0;
        int maxLeft=0, maxRight=0;
        int left=0, right=height.size()-1;
        
        while(left < right) {
            if(height[left] <= height[right]) {
                (height[left] >= maxLeft) ? (maxLeft = height[left]) : (res += maxLeft-height[left]);
                ++left;
            }
            else {
                (height[right] >= maxRight) ? (maxRight = height[right]) : (res += maxRight-height[right]);
                --right;
            }
        }

        return res;
    }
};