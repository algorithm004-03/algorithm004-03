class LRUCache {
public:
    LRUCache(int capacity) : capacity_(capacity) {}

    int get(int key) {
        if (hash_.find(key) == hash_.end())
            return -1;
        else {
            int value = hash_[key]->second;
            ls_.erase(hash_[key]);
            ls_.push_front(make_pair(key, value));
            hash_[key] = ls_.begin();
            return value;
        }
    }

    void put(int key, int value) {
        if (hash_.find(key) != hash_.end())
            ls_.erase(hash_[key]);
        else if (ls_.size() >= capacity_) {
            hash_.erase(ls_.back().first);
            ls_.pop_back();
        }
        ls_.push_front(make_pair(key, value));
        hash_[key] = ls_.begin();
    }

private:
    int capacity_;
    list<pair<int, int>> ls_;
    unordered_map<int, list<pair<int, int>>::iterator> hash_;
};