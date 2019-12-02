import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(0, 0, n, result, "");
        return result;
    }

    private void generate(int left, int right, int n, List<String> result, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, result, s + "(");
        }

        if (right < left) {
            generate(left, right + 1, n, result, s + ")");
        }
    }
}