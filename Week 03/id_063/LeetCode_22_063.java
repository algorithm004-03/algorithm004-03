/*
思路
递归生成字符串，最多递归n层，每层维护左括号和右括号的数量
往下递归的条件是左括号数量大于右括号，且左右括号数量都不超过n
*/

class Solution {
    List<String> dfs(List<String> result, int leftCnt, int rightCnt, int maxCnt, char[] path, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            result.add(new String(path));
            return result;
        }

        if (leftCnt < maxCnt) {
            path[curLevel] = '(';
            dfs(result, leftCnt + 1, rightCnt, maxCnt, path, curLevel + 1, maxLevel);
        }

        if ((rightCnt < maxCnt) && (leftCnt > rightCnt)) {
            path[curLevel] = ')';
            dfs(result, leftCnt, rightCnt + 1, maxCnt, path, curLevel + 1, maxLevel);
        }

        return result;
    }

    public List<String> generateParenthesis(int n) {
        return dfs(new ArrayList<>(n<<1), 0, 0, n, new char[n<<1], 0, n<<1);
    }
}