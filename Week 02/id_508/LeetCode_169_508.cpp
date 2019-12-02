class Solution {
public:
    int majorityElement(vector<int>& nums) {

        return divide(nums,0,nums.size()-1);

    }
    int divide(vector<int>&nums,int i,int j) {
        if(i==j) return nums[i];
        else {
            int m1 = divide(nums,i,(i+j)/2);
            int m2 = divide(nums,(i+j)/2+1,j);
            return merge(nums,i,j,m1,m2);

        }
    }
    int merge(vector<int>&nums,int i,int j,int m1,int m2) {
        if(m1==m2) return m1;

                int cm1=0;
                int cm2 = 0;
                for(int ii=i;ii<=j;ii++) {
                    if(nums[ii]==m1) cm1++;
                    else if(nums[ii]==m2) cm2++;
                }
                return cm1>=cm2?m1:m2;
    }
};
