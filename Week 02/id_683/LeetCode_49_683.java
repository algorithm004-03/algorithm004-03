import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            int[] letters = new int[26];
            for (int i = 0; i < str.length(); ++i) {
                letters[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(letters);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}