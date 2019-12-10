class Solution {

public:

    string reverseWords(string s) {

        stack<string> st;

        int pos = 0;



        while (true) {

            pos = s.find_first_not_of(' ', pos);    // 指向单词首字母

            if (pos == string::npos)

                break;

            st.push(s.substr(pos, s.find(' ', pos) - pos));    // 储存单词

            pos = s.find(' ', pos);    // 找到单词后的位置

        }

        string out;

        while (!st.empty()) {

            out += st.top() + " ";

            st.pop();

        }

        out.pop_back();    //删除多余空格

        return out;

    }

};
