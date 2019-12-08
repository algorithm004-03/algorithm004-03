/*
 * 208. 实现 Trie (前缀树)
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
    
    bool search(string word) {
        Trie* node = this;
        for(char ch : word) {
            if(node->links[ch-'a'] == NULL)
                return false;
            node = node->links[ch-'a'];
        }
        return node->end;
    }
    
    bool startsWith(string prefix) {
        Trie* node = this;
        for(char ch : prefix) {
            if(node->links[ch-'a'] == NULL)
                return false;
            node = node->links[ch-'a'];
        }
        return true;
    }
};