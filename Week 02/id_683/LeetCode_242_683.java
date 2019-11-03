class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            counter[sChar[i] - 'a']++;
            counter[tChar[i] - 'a']--;
        }

        for (int num : counter) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}