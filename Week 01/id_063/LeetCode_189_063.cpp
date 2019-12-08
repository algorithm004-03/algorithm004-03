/*
思路
整个数组左右对换，然后前k个左右对换对换，前k个后面的所有元素左右对换
 */


#include <vector>
using namespace std;

class Solution {
private:
    void swap(int& num1, int& num2) {
        int tmp;
        tmp = num1; num1 = num2; num2 = tmp;
    }

public:
    void rotate(vector<int>& nums, int k) {
        if ((nums.empty()) || (k%nums.size() == 0)) {
            return;
        }

        k %= nums.size();
        for (int i = 0, j = nums.size()-1; i < j; i++, j--) {
            swap(nums[i], nums[j]);
        }

        for (int i = 0, j = k-1; i < j; i++, j--) {
            swap(nums[i], nums[j]);
        }

        for (int i = k, j = nums.size()-1; i < j; i++, j--) {
            swap(nums[i], nums[j]);
        }
    }
};
