// by hash
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { return false; }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a'] += 1;
            counter[t.charAt(i) - 'a'] -= 1;
        }
        for (int v : counter) {
            if (v != 0) { return false; }
        }
        return true;
    }
}

// by sorted string
class Solution2 {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}

// by hash
class Solution3 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int old;
        for (char c : s.toCharArray()) {
            old = map.getOrDefault(c, 0);
            map.put(c, old+1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) { return false; }
            map.put(c, map.get(c)-1);
        }
        for (int v : map.values()) {
            if (v != 0) { return false; }
        }
        return true;
    }
}