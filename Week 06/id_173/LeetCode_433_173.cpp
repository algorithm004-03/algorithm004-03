/*
 * 433. 最小基因变化
 */

class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> genePool(bank.begin(), bank.end());
        if(!genePool.count(end))
            return -1;
        
        unordered_set<string> curEnd({start});
        unordered_set<string> otherEnd({end});
        vector<char> character = {'A', 'C', 'G', 'T'};
        int times = 1;

        while(!curEnd.empty() && !otherEnd.empty()) {
            if(otherEnd.size() < curEnd.size())
                swap(curEnd, otherEnd);
            
            unordered_set<string> temp;
            for(string str : curEnd) {
                for(int i=0; i<str.size(); ++i) {
                    char c = str[i];
                    for(int j=0; j<4; ++j) {
                        str[i] = character[j];
                        if(otherEnd.count(str))
                            return times;
                        if(genePool.count(str)) {
                            genePool.erase(str);
                            temp.insert(str);
                        }
                    }
                    str[i] = c;
                }
            }

            swap(temp, curEnd);
            times++;
        }

        return -1;
    }
};