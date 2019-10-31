class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        int cache;
        int level = 0;
        int next = 0;
        int start = 0;
        while(level<n) {
             cache = nums[start];
             next = start;
             do {
                next = getNewPosition(n,next,k);
                swap(cache,nums[next]);
                level++;
            } while(start!=next);
            start++;
        }
    }
    inline int getNewPosition(int len, int p, int k) {
        return (p+k)%len;
    }
    inline void swap(int& a, int& b) {
        int cache = a;
        a = b;
        b = cache;
    }
};
