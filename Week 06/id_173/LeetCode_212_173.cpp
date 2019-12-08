/*
 * 212. 单词搜索 II
 */

class Trie {
private:
    Trie* links[26];
    bool end;

public:
    Trie() {
        memset(links, NULL, sizeof(links));
        end = false;
    }
    
    void insert(string word) {
        Trie* node = this;
        for(char ch : word) {
            if(node->links[ch-'a'] == NULL)
                node->links[ch-'a'] = new Trie();
            node = node->links[ch-'a'];
        }
        node->end = true;
    }
    
    Trie* get(char ch) {
        return links[ch-'a'];
    }

    bool isEnd() {
        return end;
    }
};

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> res;
        
        if(board.empty() || words.empty())
            return res;

        Trie trie;
        for(string word : words) {
            trie.insert(word);
        }

        unordered_set<string> hashTable;
        for(int i=0; i<board.size(); ++i) {
            for(int j=0; j<board[0].size(); ++j) {
                helper(board, i, j, "", &trie, hashTable);
            }
        }

        for(string word : hashTable) {
            res.push_back(word);
        }

        return res;
    }

    void helper(vector<vector<char>>& board, int i, int j, string curString, Trie* curTrie, unordered_set<string>& hashTable) {
        curString += board[i][j];
        curTrie = curTrie->get(board[i][j]);
        if(curTrie == NULL)
            return;
        if(curTrie->isEnd())
            hashTable.insert(curString);
        
        char temp = board[i][j];
        board[i][j] = '#';

        for(int k=0; k<4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=0 && x<board.size() && y>=0 && y<board[0].size() && board[x][y]!='#')
                helper(board, x, y, curString, curTrie, hashTable);
        }

        board[i][j] = temp;
    }
};