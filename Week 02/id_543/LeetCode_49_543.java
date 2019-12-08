class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        }
        List<List<String>> reslutList = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (String s:strs){
            String tmp = s;
            char[] tmpChars = s.toCharArray();
            Arrays.sort(tmpChars);
            String tmpp = new String(tmpChars);
            List<String> tmpList = new ArrayList<String>();
            if(map.containsKey(tmpp)){
                tmpList = map.get(tmpp);
            }
            tmpList.add(s);
            map.put(tmpp,tmpList);
        }
        for(List<String> anagramList:map.values()){
            reslutList.add(anagramList);
        }
        return reslutList;
    }


    //官方题解
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    /**
     * 1.map中对象修改，无需再重新再put一遍
     * 2.new ArrayList(ans.valuse())
     * 3.new String(char[]) 与string.values(char[])都可将char[]转为String。char[].toString=[C@4367e003。
     * @后是数组的哈希码，默认情况下，该哈希码是数组的内存地址。
     */
}