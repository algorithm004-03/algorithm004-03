//22. 括号生成

//解法1：回溯法
//思路：首先获取到所有可能的括号组合,然后添加约束条件,筛选出所有符合要求的str：
//			左括号可以出现在任意位置,而右括号只能出现在左括号的后面
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backStrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backStrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max*2) {
            res.add(str);
            return;
        }
        if (open < max) {
            backStrack(res, str+"(", open + 1, close, max);
        }
        if (close < open) {
            backStrack(res, str+")", open, close + 1, max);
        }
    }
}

//解法2：bfs解法
//思路：创建一个队列用于维护每次添加的括号组合, 当poll的str长度为n*2时将其添加到result
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("(");

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.length() == n*2) result.add(str);
            
            int left = countMehodLeft(str);//获取str中的左括号数
            int right = countMethodRight(str);//获取str中的右括号数

            if (left < n) {
                queue.offer(str + "(");
            }
            if (right < left) {
                queue.offer(str + ")");
            }
        }
        return result;
    }

    private int countMehodLeft(String str) {
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == '('){
                count++;
            }
        }
        return count;
    }

    private int countMethodRight(String str) {
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == ')'){
                count++;
            }
        }
        return count;
    }
}