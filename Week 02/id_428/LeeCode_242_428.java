
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
		
		//hash 区分大小写
//        int[] counter = new int[26*2+6];
//        for (int i = 0; i < s.length(); i++) {
//            counter[s.charAt(i) - 'A']++;
//            counter[t.charAt(i) - 'A']--;
//        }

        //Arrays sort 39%
//        char[] sc = s.toCharArray();
//        char[] tc = t.toCharArray();
//        Arrays.sort(sc);
//        Arrays.sort(tc);
//        return Arrays.equals(sc, tc);

        return true;
    }
	
}