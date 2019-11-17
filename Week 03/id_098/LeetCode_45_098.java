//仿照老师55题贪心算法，最优解解析
class Solution {
    public int jump(int[] nums) {

        int n = nums.length;

        if(n < 2) return 0;
        //上一步最远长度下标
        int pre_max_idx = nums[0];
        //当前最远长度下标
        int cur_max_idx = nums[0];
        //默认至少跳一步
        int jump_min = 1;

        for(int i = 0;i < n;i++){
            //当前下标 > 当前最远长度下标则需要跳跃，
            //同时将当前最远距离更新，因为终点肯定可到达
            //当在最远长度范围内可以不跳
            if(i > cur_max_idx){
                jump_min++;
                cur_max_idx = pre_max_idx;
            }
            //当前可跳下标超过前最远长度时，更新前最远距离下标
            if(pre_max_idx < nums[i] + i)
                pre_max_idx = nums[i] + i;
        }
        return jump_min;

    }
}