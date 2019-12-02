class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string>ans;
        addptr(ans, "", n, 0);
        return ans;
    }
    void addptr(vector<string>&v, string str, int n, int m) {
        if (n == 0 && m == 0) {
           v.push_back(str); 
        }
        
        if(n > 0) addptr(v, str+"(", n-1, m+1);
        if(m > 0) addptr(v, str+")", n, m-1);
    }
    
};
