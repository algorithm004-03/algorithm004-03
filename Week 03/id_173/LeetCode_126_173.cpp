/*
 * 126. 单词接龙 II
 */

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> res;
        unordered_set<string> wordDict(wordList.begin(), wordList.end());

        if(wordDict.empty() || !wordDict.count(endWord))
            return res;
        
        queue<vector<string>> paths; //存取所有可能的转换序列
        paths.push({beginWord});
        unordered_set<string> visited;
        int length = 1, minLength = INT_MAX;

        while(!paths.empty()) {
            if(length > minLength) //超出最短转换序列的长度，则跳出循环
                break;
            
            for(string s : visited) //将字典中上层已访问过的单词剔除，防止再次访问
                wordDict.erase(s);

            visited.clear();
            
            int size = paths.size();

            for(int i=0; i<size; ++i) { //遍历 paths 中的转换序列
                vector<string> path = paths.front();
                paths.pop();

                string str = path.back(); //获取当前序列的最后一个单词
                for(int j=0; j<str.size(); ++j) {
                    char c = str[j];
                    for(char k='a'; k<='z'; ++k) {
                        str[j] = k;
                        if(wordDict.count(str)) { //若 str 在字典中，则加入到当前转换序列中组成新的序列
                            vector<string> newPath = path;
                            newPath.push_back(str);
                            if(str == endWord) { //当前 str 是目标单词
                                minLength = length; //更新最短转换序列长度
                                res.push_back(newPath); //将符合要求的转换序列进行存放
                            }
                            else { //当前 str 不是目标单词
                                visited.insert(str); //将 str 加入到已访问集合中
                                paths.push(newPath); //将新的转换序列加入到paths中
                            }
                        }
                    }
                    str[j] = c;
                }
            }

            length++; //转换序列长度加一
        }

        return res;
    }
};