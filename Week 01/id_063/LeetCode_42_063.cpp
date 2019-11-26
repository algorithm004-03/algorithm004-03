/*
动态规划算法, 暴力算法迭代每一根柱子都需要左右两个方向扫描到底查找左边最高的柱子和右边最高柱子
进行了重复计算，可以用动态规划的方式先把每个柱子左边最高的柱子高度和每个柱子右边最高的柱子高度算出来

设dpLeftMax[i] 表示柱子i左边最高的柱子高度, 则有如下递推关系
    若 height[i-1] > dpLeftMax[i-1], 则dpLeftMax[i] = height[i-1]
    否则 dpLeftMax[i] = dpLeftMax[i-1]

设dpRightMax[i] 表示柱子i右边最高的柱子的高度，有如下递推关系
    若 height[i+1] > dpRightMax[i+1], 则dpRightMax[i] = height[i+1]
    否则 dpRightMax[i] = dpRightMax[i+1]

    两次线性扫描可以更新完两个Dp数组，第三次从左到右扫描所有柱子计算每一个柱子的出水量，然后累加即可
*/

#include <vector>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() == 0) {
            return 0;
        }

        int len = height.size();
        vector<int> dpLeftMax(len);
        vector<int> dpRightMax(len);

        dpLeftMax[0] = 0;
        for (int i = 1; i < len; i++) {
            dpLeftMax[i] = (height[i-1] > dpLeftMax[i-1]) ? height[i-1] : dpLeftMax[i-1];
        }

        dpRightMax[len-1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            dpRightMax[i] = (height[i+1] > dpRightMax[i+1]) ? height[i+1] : dpRightMax[i+1];
        }

        int area = 0;
        int water_height;
        for (int i = 0; i < len; i++) {
            water_height = (dpLeftMax[i] < dpRightMax[i]) ? dpLeftMax[i] : dpRightMax[i];
            if (water_height > height[i]) {
                area += (water_height - height[i]);
            }
        }

        return area;
    }
};