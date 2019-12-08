/*
思路

众数x是数量超过了总数一半的数字，那么如果把序列以任意比例切成两半，那么x至少是两部分子
序列其中一个序列的众数，这个可以进行反证，如果x在两个子序列中数量都没有超过一半，两个子序列
并在一起，x总数怎么可能超过总数一半呢？

所以子序列中的众数是全序列众数的候选者，两个子序列至少一个序列有众数，否则不可能全序列有众数（题目说了输入数据保证全局有众数）
如果只有一个候选者，那最终众数必然就是这个候选者
如果两个子序列都产生了候选者，需要统计两个候选者在总序列中的频数，必然有一个胜出者

基于以上的逻辑进行分治查找
可以用ForkJoin线程池实现多线程的分治
*/


#include <vector>
using namespace std;

class Solution {
public:

    bool is_major(vector<int>& nums, int start, int end, int num) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                cnt++;
            }
        }

        return (cnt > ((end - start) + 1) >> 1);
    }

    int get_major(vector<int>& nums, int start, int end) {
        bool find_major;
        return get_major(nums, start, end, find_major);
    }

    int get_major(vector<int>& nums, int start, int end, bool& find_major) {
        if (start == end) {
            find_major = true;
            return nums[start];
        }

        bool find_left_major = false;
        bool find_right_major = false;

        int left_major = get_major(nums, start, start + (end-start+1)/2 -1, find_left_major);
        int right_major = get_major(nums, start + (end-start+1)/2, end, find_right_major);
        int major = 0;

        if (find_left_major && is_major(nums, start, end, left_major)) {
            find_major = true;
            major = left_major;
        }

        if (find_right_major && is_major(nums, start, end, right_major)) {
            find_major = true;
            major = right_major;
        }

        return major;
    }

    int majorityElement(vector<int>& nums) {
        return get_major(nums, 0, nums.size()-1);
    }
};