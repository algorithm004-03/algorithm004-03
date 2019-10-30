/*
思路
把每一个字符串映射成一个统计字符频率和所有字符个数的结构，用该结构作为Map的key,Map的值
为容纳相同的key的字符串的List，迭代每一个字符串，更新Map结构，最后把Map中所有的Value全
放到结果的List中去即可
 */

#include <vector>
#include <string>
#include <map>
using namespace std;

struct Node {
    int char_cnt[26];
    int char_num;
};

bool operator < (const Node& node1, const Node& node2) {
    if (node1.char_num < node2.char_num) {
        return true;
    } else if (node1.char_num > node2.char_num) {
        return false;
    }
    
    for (int i = 0; i < sizeof(node1.char_cnt)/sizeof(node1.char_cnt[0]); i++) {
        if (node1.char_cnt[i] < node2.char_cnt[i]) {
            return true;
        } else if (node1.char_cnt[i] > node2.char_cnt[i]) {
            return false;
        }
    }
    
    return false;
}


class Solution {
private:
    void get_node(string& str, Node& node) {
        memset((void*)node.char_cnt, 0, sizeof(node.char_cnt));
        for (int i = 0; i < str.length(); i++) {
            node.char_cnt[str[i]-'a']++;
        }
        
        node.char_num = (int)str.size();
    }
    
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> v;
        Node key;
        map<Node, vector<string>> m;
        
        for (string& s : strs) {
            get_node(s, key);
            m[key].push_back(s);
        }
        
        for (auto itr = m.begin(); itr != m.end(); itr++) {
            v.push_back(itr->second);
        }
        
        return v;
    }
};