class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        unsigned long long N = (1<<n)-1;
        vector<vector<unsigned long long>> result;
        vector<vector<string>> rn;
        vector<unsigned long long> current;;
        sQueen(N,result,0,current,0,0,0);
        show(result,rn,n);
        return rn;
    }
    void show(vector<vector<unsigned long long>>& current,vector<vector<string>>& result,int n) {

        vector<vector<unsigned long long>>::iterator iters = current.begin();
        for(iters = current.begin();iters!=current.end();iters++) {
            vector<unsigned long long>::iterator iter2 = iters->begin();
            vector<string> str;

            for(iter2=iters->begin();iter2!=iters->end();iter2++) {
                string temp = "";
                for(int i=0;i<n;i++) {
                    if(*iter2&1) temp+="Q";
                    else temp+=".";
                    *iter2=*iter2>>1;
                }
                str.push_back(temp);
            }
            result.push_back(str);
        }
    }
    void display(vector<vector<unsigned long long>> result,vector<vector<string>> rn) {
        int nrn = rn.size();

    }
    void sQueen( unsigned long long N, vector<vector<unsigned long long>>& result, int n, vector<unsigned long long> current,unsigned long long last ,unsigned long long left,unsigned long long right) {
        if (n ==N ) {
            result.push_back(current);
            return;
        }


        long pos = N&~(last|left|right);
        while(pos) {
            int p = pos&(~pos+1);
            pos-=p;
            current.push_back(p);
            sQueen(N,result,n+p,current,last+p,(left+p)<<1,(right+p)>>1);
            current.pop_back();
        }

    }
};
