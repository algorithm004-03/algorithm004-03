class Solution {
    typedef unsigned long long ull;
public:
    int climbStairs(int n) {
    ull pprev=1,prev=1;
    int cur = 0;
    ull sum = 0;
    while(cur++<n) {
        sum=prev+pprev;
        pprev = prev;
        prev = sum;
    }
    return pprev;
    }
};
