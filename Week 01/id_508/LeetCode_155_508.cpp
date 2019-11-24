class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {

    }

    void push(int x) {
        st.push_back(x);
        if(min.empty()||x<=min.back())
            min.push_back(x);
    }

    void pop() {
        if(!st.empty()&&!min.empty()&&st.back()==min.back()){
            st.pop_back();
            min.pop_back();
        } else {
            st.pop_back();
        }
    }

    int top() {
        if(!st.empty())
        return st.back();
        else return -1;
    }

    int getMin() {
         if(!min.empty()) return min.back();
        else return -1;
    }
    deque<int> st;
    deque<int> min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
