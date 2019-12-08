class Solution {
public:
    int trap(vector<int>& height) {
        deque<int> s;
        int res = 0;
        for(int current=0;current<height.size();current++) {
            while(!s.empty()&&height[current]>height[s.back()]) {
                int top = s.back();
                s.pop_back();
                if(s.empty()) break;
                int dis = current-s.back() - 1;
                res += dis*(min(height[current],height[s.back()])-height[top]);
            }
            s.push_back(current);
        }
        return res;
    }
};
