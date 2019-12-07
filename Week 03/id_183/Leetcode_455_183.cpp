/*
 * @lc app=leetcode id=455 lang=cpp
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
public:
    static bool cmp(const int &a,const int &b)
    {
        return a<b;
    }
    int findContentChildren(vector<int>& g, vector<int>& s) {
        if(g.size()<1) return 0;
        sort(s.begin(),s.end(),cmp);
        sort(g.begin(),g.end(),cmp);
        int num=0;
        //对于每个小朋友
        for(int i=0;i<g.size();i++)
        {
            //检查是否有一块饼干适合这个小朋友
            for(int j=0;j<s.size();j++)
            {
                //只有当饼干的大小大于小朋友的胃口时饼干立即分配给该小朋友
                if(s[j]>=g[i])
                {
                    num++;
                    //这块饼干退出
                    s.erase(s.begin()+j);
                    break;
                }
            }
            //小朋友也退出
            g.erase(g.begin()+i);
            //由于size-，
            //i--对应队列的第一个小朋友
            i--;
        }
        return num;
    }
};

// @lc code=end

