/*
 * 146. LRU缓存机制
 */

class LRUCache {
private:
    struct DLNode {
        int key;
        int value;
        DLNode *prev;
        DLNode *next;
        DLNode() : key(0), value(0), prev(nullptr), next(nullptr) {}
    };

    DLNode *head;
    DLNode *tail;

    unordered_map<int, DLNode*> cache;
    int size;
    int capacity;

    void addHead(DLNode* node) {
        node->prev = head;
        node->next = head->next;
        head->next->prev = node;
        head->next = node;
    }

    void removeNode(DLNode* node) {
        DLNode* prev = node->prev;
        DLNode* next = node->next;
        prev->next = next;
        next->prev = prev;
    }

    DLNode* removeTail() {
        DLNode* node = tail->prev;
        removeNode(node);
        return node;
    }

    void moveToHead(DLNode* node) {
        removeNode(node);
        addHead(node);
    }

public:
    LRUCache(int capacity) {
        this->size = 0;
        this->capacity = capacity;
        head = new DLNode();
        tail = new DLNode();
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(cache.count(key) == 0)
            return -1;
        DLNode* node = cache[key];
        moveToHead(node);
        return node->value;
    }
    
    void put(int key, int value) {
        if(cache.count(key) == 0) {
            DLNode* newNode = new DLNode();
            newNode->key = key;
            newNode->value = value;
            addHead(newNode);
            cache.insert({key, newNode});
            ++size;
            if(size > capacity) {
                DLNode* node = removeTail();
                cache.erase(node->key);
                --size;
            }
        }
        else {
            DLNode* node = cache[key];
            node->value = value;
            moveToHead(node);
        }
    }
};