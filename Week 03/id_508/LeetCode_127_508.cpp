class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> visited;
        unordered_set<string> dict(wordList.begin(), wordList.end());
        deque<string> que;

        que.push_back(beginWord);
        int res = 0;
        int result = 0;
        while(!que.empty()) {
            int size = que.size();
            res++;
            while(size--) {
                auto word = que.front();
                que.pop_front();
                if(word == endWord) {
                    que.clear();
                    result = res;
                    break;
                }
                if(visited.find(word)==visited.end()) {
                    visited.insert(word);
                    string rem = word;
                    for(int index=0;index<word.size();index++) {
                        for(int i = 0;i<26;i++) {
                            word[index] = 'a'+i;
                            if(dict.find(word)!=dict.end()) {
                                 if(visited.find(word)==visited.end())
                                que.push_back(word);
                            }
                        word = rem;
                        }

                    }
                }
            }
        }

        return result;
    }


};
