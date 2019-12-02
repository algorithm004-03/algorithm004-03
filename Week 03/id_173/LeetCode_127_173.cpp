/*
 * 127. 单词接龙
 */

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordDict(wordList.begin(), wordList.end());
        if(!wordDict.count(endWord))
            return 0;
        
        unordered_set<string> curEnd({beginWord});
        unordered_set<string> otherEnd({endWord});
        int length = 1;
        
        while(!curEnd.empty() && !otherEnd.empty()) {
            if(otherEnd.size() < curEnd.size())
                swap(curEnd, otherEnd);
            
            unordered_set<string> tempSet;
            for(string str : curEnd) {
                for(int i=0; i<str.size(); ++i) {
                    char c = str[i];
                    for(int j=0; j<26; ++j) {
                        str[i] = 'a'+j;
                        if(otherEnd.count(str))
                            return length+1;
                        if(wordDict.count(str)) {
                            wordDict.erase(str);
                            tempSet.insert(str);
                        }
                    }
                    str[i] = c;
                }
            }

            swap(curEnd, tempSet);
            length++;
        }

        return 0;
    }
};