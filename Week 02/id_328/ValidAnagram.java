class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i = 0 ; i < sChars.length ; i++) {
            if(charMap.containsKey(sChars[i])) {
                charMap.put(sChars[i], charMap.get(sChars[i]) + 1);
            }else {
               charMap.put(sChars[i], 1);
            }
        }
        for(int i = 0 ; i < tChars.length ; i++) {
            if(charMap.containsKey(tChars[i])) {
                charMap.put(tChars[i], charMap.get(tChars[i]) - 1);
            }else {
                return false;
            }
        }
        
        for(Character key : charMap.keySet()) {
            if(charMap.get(key) != 0) return false;
        }
        
        return true;
    }
}