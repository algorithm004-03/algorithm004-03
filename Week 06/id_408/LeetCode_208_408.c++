class Trie {
public:
    
    Trie() : nexts{ nullptr }, count(0){
        
    }
    
    ~Trie() {
        
        for (size_t i= 0; i < 27; ++i) {
            if (nexts[i]) delete nexts[i];
        }
    }
    
    
    void insert(string word) {
        Trie*   curr = this;
        size_t  idx = 0;
        
        for (char ch : word) {
            idx = ch - 'a';
            
            if (!curr->nexts[idx]) {
                curr->nexts[idx] = new Trie();
            }
            curr = curr->nexts[idx];
        }
        ++curr->count;
    }
    
    
    bool search(string word) {
        Trie* last = getLast(word);
        return last && last->count > 0;
    }
    
    
    bool startsWith(string prefix) {
        Trie* last = getLast(prefix);
        return last;
    }

private:
    Trie* getLast(string prefix) {
        
        Trie*   curr = this;
        size_t  idx = 0;
        
        for (char ch : prefix) {
            idx = ch - 'a';

            if (!curr->nexts[idx]) {
                return nullptr;
            }
            curr = curr->nexts[idx];
        }
        
        return curr;
    }
    
    Trie*   nexts[27];
    int     count;
};
