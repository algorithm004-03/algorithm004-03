class Solution {
public:
    int hammingWeight(uint32_t n) {
        int an=0;
        for(int i=1;i<=32;i++)
        {
            if(n&1) an++;
            n=n>>1;
        }
        return an;
    }
};
