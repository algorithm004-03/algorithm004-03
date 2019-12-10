class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        int pos = s.length() - 1;
        while (pos >= 0 && s.charAt(pos) == ' ') pos--;
        while (pos >= 0 && s.charAt(pos) != ' ') {
            ans++;
            pos--;
        }
        return ans;
    }
}