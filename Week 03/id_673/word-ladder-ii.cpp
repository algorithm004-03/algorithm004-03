class Solution {
public:
    bool sim(const string& s1, const string& s2) {
        int diff = 0;
        for (int i = 0; i < s1.size(); ++i) {
            diff += s1[i] != s2[i];
        }
        return diff <= 1;
    }
    void dfs(const vector<vector<int> >& g, const vector<int>& dfn, const vector<string>& wordList,
            int i, vector<string>& path, vector<vector<string> >& paths) {
        if (dfn[i] == 0) {
            vector<string> v(path);
            reverse(v.begin(), v.end());
            paths.push_back(v);
            return;
        }
        for (auto j : g[i]) {
            if (dfn[j] == dfn[i] - 1) {
                path.push_back(wordList[j]);
                dfs(g, dfn, wordList, j, path, paths);
                path.pop_back();
            }
        }
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        wordList.push_back(beginWord);
        int N = wordList.size();
        vector<vector<int> > g(N);
        int endi = -1;
        // 构图
        for (int i = 0; i < N; ++i) {
            if (wordList[i] == endWord) endi = i;
            for (int j = i + 1; j < N; ++j) {
                if (sim(wordList[i], wordList[j])) {
                    g[i].push_back(j);
                    g[j].push_back(i);
                }
            }
        }
        if (endi == -1) return {};
        // 层级编号
        vector<int> dfn(N, -1);
        queue<int> q;
        q.push(N - 1);
        dfn[N - 1] = 0;
        while (!q.empty()) {
            auto i = q.front();
            q.pop();
            for (auto j : g[i]) {
                if (dfn[j] == -1) {
                    dfn[j] = dfn[i] + 1;
                    q.push(j);
                }
            }
        }
        if (dfn[endi] == -1) return {};
        // 回溯路径
        vector<string> path{endWord};
        vector<vector<string> > paths;
        dfs(g, dfn, wordList, endi, path, paths);
        return paths;
    }
};
