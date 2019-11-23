/*
 * @lc app=leetcode id=146 lang=cpp
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
private:
        int cap;
        //double linked list: key & val
        list<pair<int,int>> cache;
        //hash table: position that key --> (key , cal)in cache
        unordered_map<int,list<pair<int,int>>::iterator> map;  
public:
    LRUCache(int capacity) {
       this->cap = capacity;
    }   
    int get(int key) {
        auto it = map.find(key);
        //key not exist
        if(it == map.end()) return -1;
        //key exist, (k,v) in font of queue
        pair<int,int> kv = *map[key];
        cache.erase(map[key]);
        cache.push_front(kv);
        //update cache
        map[key] = cache.begin();
        return kv.second; //value
    }
    
    void put(int key, int value) {
        //whether the key exist
        auto it = map.find(key);
        if(it == map.end())
        {
            /*key not exust, cache is full or not*/
            if(cache.size() == cap)
            {
                //cahce is full , erase rear 
                //erase comparable elements in map and cache
                auto lastPair = cache.back();
                int lastKey = lastPair.first;
                map.erase(lastKey);
                cache.pop_back();
            }
            //cache is not full
            cache.push_front(make_pair(key,value));
            map[key] = cache.begin();
        }
        else
        {
            //key exists,change value and put it in the front
            cache.erase(map[key]);
            cache.push_front(make_pair(key,value));
            map[key] = cache.begin();
        }
        
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

