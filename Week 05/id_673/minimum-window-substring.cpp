class Solution {
private:
    //用于检查某一字符串是否包含t中的所有字符
    bool is_window_ok(int map_s[],int map_t[],vector<int> &vec_t){
        for(int i=0;i<vec_t.size();++i){  //利用vec_t遍历t中出现的字符
            if(map_s[vec_t[i]]<map_t[vec_t[i]]){
                return false;  //如果s中出现该字符的数量小于t中出现该字符的数量，返回false
            }
        }
        return true;
    }
public:
    string minWindow(string s, string t) {
        const int MAX=128; //char0-127，利用数组下标记录字符个数
        int map_s[MAX]={0}; //记录s字符串各字符个数
        int map_t[MAX]={0}; //记录t字符串各字符个数
        vector<int> vec_t;  //记录t中有哪些字符
        for(int i=0;i<s.length();++i){
            ++map_s[s[i]];  //遍历s，记录s中字符个数
        }
        for(int i=0;i<t.length();++i){
            ++map_t[t[i]];  //遍历t，记录t中字符个数
        }
        for(int i=0;i<MAX;++i){
            if(map_t[i]>0){
                vec_t.push_back(i); //遍历，将字符串t中出现的字符存储到vec_t中
            }
        }
        //判断s中是否存在这样的子串
        if(!is_window_ok(map_s,map_t,vec_t)){
            return ""; //如果不存在，返回""
        }
        //如果存在，往下执行
        int begin=0; //最小窗口起始指针
        string result=s; //结果字符串
        int map_window[MAX]={0}; //记录窗口中的字符个数
        for(int i=0;i<s.length();++i){
            ++map_window[s[i]]; //记录当前窗口中字符串的字符数量
            while(begin<i){ //检查begin指针是否需要前移
                char begin_ch=s[begin];
                if(map_t[begin_ch]==0){ //如果当前begin所指字符没有在t中出现
                    ++begin;
                }
                else if(map_window[begin_ch]>map_t[begin_ch]){//如果当前begin所指字符在当前窗口中的数量大于t中的数量
                    --map_window[begin_ch];  //更新当前窗口的字符数量
                    ++begin;  
                }
                else{
                    break; //如果没有上面的两种情况，结束此次begin的判断
                }
            }
            //检查当前窗口字符串是否符合要求
            if(is_window_ok(map_window,map_t,vec_t)){
                int new_window_len=i-begin+1;
                if(new_window_len<result.size()){ //若符合要求，且新的字符串要比之前的短，则更新结果字符串
                    result=s.substr(begin,new_window_len);
                }
            }
        }
        return result;
    }
};
