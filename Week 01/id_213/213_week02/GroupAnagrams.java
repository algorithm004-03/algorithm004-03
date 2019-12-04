class Solution {
//主要思路是：将字符串变成字符数组，并且排序。
//让互为异位词的字符串以数组形式存入，然后以某一键值存入。
//遍历结束，分类完毕。
//获取map的值对象，得到的应该是一系列的值，存入ArrayList即可。
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList());
            }map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

}