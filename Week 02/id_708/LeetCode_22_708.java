class Solution {
    private List<String> ret = new LinkedList<>();
    
    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return ret;
    }
    
    private void _generate(int left, int right, int n, String s) {
        if (right >= n) {
            ret.add(s);
            return ;
        }
        
        if (left < n) _generate(left+1, right, n, s + "(");
        if (left > right) _generate(left, right+1, n, s + ")");
    }
}