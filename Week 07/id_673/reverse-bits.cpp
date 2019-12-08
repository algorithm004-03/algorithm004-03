class Solution {
public:
    unordered_map<uint32_t, uint32_t> memo;
    uint32_t reverseBits(uint32_t n) {
        if (memo.count(n) > 0)
            return memo[n];
        int res = 0;
        for (int i = 0; i < 32; ++i)
            if (n & (1 << i))
                res |= 1 << (31 - i);
        memo[n] = res;
        return res;
    }
};
