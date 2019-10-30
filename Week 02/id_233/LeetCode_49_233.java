
public class LeetCode_49_233{
	/**
     * 第一种：蛮力求解
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        List<String> group = null;

        if (null != strs && strs.length <= 1) {
            group = new ArrayList<>();
            group.add(strs[0]);
            result.add(group);
            return result;
        }

        List<String> newStr = null;
        int gat = 0; //组计数器
        int nst = 0; //新计数器

        f:
        for (int i = strs.length - 1; i > 0; i--) {
            if (isAnagram(strs[0], strs[i])) {
                if (gat++ == 0) {
                    group = null;
                    group = new ArrayList<>();
                    group.add(strs[0]);
                }
                group.add(strs[i]);
            } else {
                if (nst++ == 0) {
                    newStr = null;
                    newStr = new ArrayList<>();
                }
                newStr.add(strs[i]);
            }
            if (i == 1) {
                if (gat > 0)
                    result.add(group);
                if (gat == 0) {
                    group = new ArrayList<>();
                    group.add(strs[0]);
                    result.add(group);
                }
                if (nst == 1)
                    result.add(newStr);

                if (nst > 1) {
                    strs = newStr.toArray(new String[nst]);
                    i = nst;
                    gat = 0;
                    nst = 0;
                    continue f;
                }
            }
        }
        return result;
    }


    private boolean isAnagram(String str, String str1) {
        if (str.length() != str1.length())
            return false;
        int[] words = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            words[str.charAt(i) - 'a']++;
            words[str1.charAt(i) - 'a']--;
        }
        for (int n : words) {
            if (n != 0)
                return false;
        }
        return true;
    }

    /**
     * 第二种题解
     * 将每个字符串按照字母顺序排序，这样的话就可以把 eat，tea，ate 都映射到 aet。其他的类似
     * 时间复杂度：排序的话算作 O(Klog(K))
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
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

    public List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            //累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }
}