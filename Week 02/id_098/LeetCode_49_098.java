//暴力排序法
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<List<String>>();

        HashMap<String,ArrayList<String>> map =new HashMap<>();

        for (int i=0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);

            if (map.containsKey(key)) {
                ArrayList<String> tmpList = map.get(key);
                tmpList.add(strs[i]);
                map.put(key, tmpList);
            }
            else {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(strs[i]);
                map.put(key, newList);
            }

        }

        for (List<String> v : map.values()) {
            res.add(v);
        }

        return res;
    }
}

//相对最优解，代码精炼（思路一致）
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 找到相同的字符串，主要是排序不一样
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    String sort(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}