class Solution {
    public String toLowerCase(String str) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') { 
                ret.append((char)(c+32));
            }
            else ret.append(c); 
        }
        return ret.toString();
    }
}