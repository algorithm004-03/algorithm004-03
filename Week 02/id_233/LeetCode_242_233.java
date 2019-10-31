
public class LeetCode_242_233{
	
	public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toLowerCase().toCharArray();
        char[] ct = t.toLowerCase().toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs,ct);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        s = s.toLowerCase();
        t = t.toLowerCase();
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}