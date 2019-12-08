class Solution {
    public int trap(int[] height) {
        int lo = 0, hi = height.length-1;
        int maxLeft = 0, maxRight = 0; // maxLeft: biggest between 0..lo; maxRight: biggest between hi..len(height)
        int ret = 0;
        while (lo <= hi) {
            maxLeft = Math.max(maxLeft, height[lo]);
            maxRight = Math.max(maxRight, height[hi]);
            if (maxLeft < maxRight) {
                ret += (maxLeft - height[lo]); // add water that you can save at height[lo]
                lo++;
            } else {
                ret += (maxRight - height[hi]);
                hi--;
            }
        }
        return ret;
    }
}