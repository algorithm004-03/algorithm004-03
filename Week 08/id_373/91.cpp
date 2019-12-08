class Solution {
public:
    int numDecodings(string s) {
        const int size = s.size();
        if (s.size() == 0 || s[0] == '0') // 起始位0无解
            return 0;
        int dp_last = 1;
        int dp_last_last = 1;
        for (int i = 1; i < size; i++) {
            int cv = (s[i - 1] - '0') * 10 + (s[i] - '0');
            if (cv == 0 || cv > 26 && s[i] == '0') // 00 || x0 && x0 > 26 无解
                return 0;
            // 1. 当前无法与上一个字符组合
            // 2. 当前为0只能和上一个结合
            // 3. 前一个为0只能和前一个结合
            // 4. 下一个为0 只能跟下一个结合
            if ((cv > 26 || s[i] == '0' || cv < 10) || (i < size - 1 && s[i + 1] == '0' )) {
                dp_last_last = dp_last;
            } else {
                auto dbb = dp_last_last;
                dp_last_last = dp_last;
                dp_last += dbb;
            }
        }
        return dp_last;
    }
};
