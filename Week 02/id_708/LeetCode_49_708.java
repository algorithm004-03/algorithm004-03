// by sorted string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new LinkedList<List<String>>();
        
        Map<String, List<String>> map  = new HashMap<>();
        for (String s : strs) {
            String sortedS = sort(s);
            if (!map.containsKey(sortedS)) {
                map.put(sortedS, new LinkedList<String>());
            }
            map.get(sortedS).add(s);
        }
        return new LinkedList(map.values());
    }
    
    private String sort(String s) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        return String.valueOf(sChars);
    }
}

// by ASCII hash
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new LinkedList<List<String>>();
        
        Map<String, List<String>> map  = new HashMap<>();
        int[] counter = new int[26];
        for (String s : strs) {
            String key = hashKey(s, counter);
            if (!map.containsKey(key)) map.put(key, new LinkedList<String>());
            map.get(key).add(s);
        }
        return new LinkedList(map.values());
    }
    
    private String hashKey(String s, int[] counter) {
        Arrays.fill(counter, 0);
        for (char c : s.toCharArray()) counter[c-'a'] += 1;
        StringBuilder sb = new StringBuilder();
        for (int v : counter) {
            sb.append('#'); // some char's count may great then 9
            sb.append(v);
        }
        return sb.toString();
    }
}