import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> relation = new HashMap<>(s.length());
        Set<Character> values = new HashSet<>(s.length());

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (relation.containsKey(t.charAt(i))) {
                if (relation.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                if (values.contains(s.charAt(i))) {
                    return false;
                }

                relation.put(t.charAt(i), s.charAt(i));
                values.add(s.charAt(i));
            }
        }

        return true;
    }
}