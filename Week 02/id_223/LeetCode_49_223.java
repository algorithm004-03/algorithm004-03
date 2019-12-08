class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<String,List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            // String key = new String(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}