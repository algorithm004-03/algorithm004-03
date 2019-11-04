class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        if(strs.length == 0) return new ArrayList();
        Map<String,List> ans = new HashMap<String,List>();
        for(String s : strs){
            Arrays.fill(count,0);
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key,new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
