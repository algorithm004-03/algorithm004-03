class Solution {
public:
    int father[210];
    //查找祖先节点，当节点记录的祖先是自己，则表示查找到祖先了
    int findFather(int x)
    {
        while(x!=father[x])
        {
            x = father[x];
        }
        return x;
    }
    //合并节点：设置共同祖先
    void Union(int a,int b)
    {
        int fa = findFather(a);
        int fb = findFather(b);
        if(fa!=fb)
        {
            father[fa] = fb;
        }
    }
    //最开始的时候，每个节点时分散的，都是自己的祖先
    void init()
    {
        for(int i=0;i<210;i++)
        {
            father[i] = i;
        }
    }
    //主函数
    int findCircleNum(vector<vector<int>>& M) {
        init();
        //对N个学生两两做判断
        for(int i=0;i<M.size();i++)
        {
            for(int j=i+1;j<M.size();j++)
            {
                if(M[i][j]==1)
                {
                    Union(i,j);
                }
            }
        }
        //一次遍历找到所有祖先节点，即为朋友圈的个数
        int res = 0;
        for(int i=0;i<M.size();i++)
        {
            if(i==father[i])
            {
                res++;
            }
        }
        return res;
    }
};
