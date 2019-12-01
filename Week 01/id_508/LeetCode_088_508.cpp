public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int cur = m+n-1;
        int up = m - 1;
        int dn = n - 1;
        while(cur>-1) {
            if(dn<0) break;
            if(up>-1&&nums1[up]>nums2[dn]) {
                nums1[cur--] = nums1[up--];
            } else nums1[cur--] = nums2[dn--];
        }
    }
};
