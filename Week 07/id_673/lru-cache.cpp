class LRUCache {
public:
  LRUCache(int capacity) : max_c(capacity), c(0) {}
  
  int get(int key) {
    if (reg.find(key) != reg.end()) {
      auto valReg = reg[key];
      auto val = std::get<0>(valReg);
      auto valP = std::get<1>(valReg);
      if (valP != lru_queue.begin()) {
        lru_queue.erase(valP);
        lru_queue.emplace_front(key);
        auto newValReg = make_tuple(val, lru_queue.begin());
        reg[key] = newValReg;
      }
      return val;
    } else {
      return -1;
    }
  }
  
  void put(int key, int value) {
    if (reg.find(key) != reg.end()) {
      auto valReg = reg[key];
      auto valP = std::get<1>(valReg);
      if (valP != lru_queue.begin()) {
        lru_queue.erase(valP);
        lru_queue.emplace_front(key);
      }
      auto newValReg = make_tuple(value, lru_queue.begin());
      reg[key] = newValReg;
    } else {
      lru_queue.emplace_front(key);
      auto newValReg = make_tuple(value, lru_queue.begin());
      reg[key] = newValReg;
      for (++c; c > max_c; --c) {
        auto finalK = lru_queue.back();
        reg.erase(finalK);
        lru_queue.pop_back();
      }
    }
  }

private:
  using key_type = int;
  using value_type = int;
  using it_type = list<key_type>::iterator;
  using reg_type = tuple<value_type, it_type>;

  unordered_map<key_type, reg_type> reg;
  list<key_type> lru_queue;
  int c, max_c;
};
