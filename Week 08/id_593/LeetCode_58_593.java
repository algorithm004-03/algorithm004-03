class LeetCode_58_593 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}