/*
 * @lc app=leetcode id=56 lang=cpp
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
public:
    static bool cmp(const vector<int>&a,const vector<int>&b )
    {
        if(a[0]==b[0])
            return a[1]>b[1];
        return a[0]<b[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.empty()) return intervals;
        vector<vector<int>> res;
        int count=0;
        sort(intervals.begin(),intervals.end(),cmp);
        vector<int> temp;
        temp.push_back(intervals[0][0]);
        temp.push_back(intervals[0][1]);
        res.push_back(temp);
        for(int i=1;i<intervals.size();i++)
        {
            if(res[count][1]>=intervals[i][0])
            {
                if(res[count][1]<=intervals[i][1])
                {
                    res[count][1]=intervals[i][1];
                }
            }
            else
            {
                count++;
                temp[0]=intervals[i][0];
                temp[1]=intervals[i][1];
                res.push_back(temp);
            }
        }
        return res;
    }
};

// @lc code=end

