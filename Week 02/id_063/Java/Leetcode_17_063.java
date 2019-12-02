import java.util.LinkedList;
import java.util.List;


/*
输入数字从左到右每一个代表递归的一层，每一层递归顺序选择本层数字对应的字符中的一个，然后继续下一层
递归，递归深度到数字总数时候保存结果并且进行回溯即可
*/

class Solution {
    private static String[] num2str = new String[] {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    List<String> dfs(List<String> result, String path, String digits, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            result.add(path);
            return result;
        }

        String chars = num2str[digits.charAt(curLevel)-'0'];
        for (int i = 0; i < chars.length(); i++) {
            dfs(result, path + chars.charAt(i), digits, curLevel+1, maxLevel);
        }

        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new LinkedList<String>();
        }

        return dfs(new LinkedList<String>(), "", digits, 0, digits.length());
    }
}