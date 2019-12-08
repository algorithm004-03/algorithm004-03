package id_693;

import java.util.*;

/**
 * @Desc 49. 字母异位词分组   https://leetcode-cn.com/problems/group-anagrams/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_49_693 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //暴力破解， O(NKlogK)
        // 1、直接对字符串进行排序，
        // 2、然后，转换为字符串保存到hash表中(字符串地址为key，添加的list下标为value)，
        //      如果存在，则直接获得list下标进行添加
        List<List<String>> lists = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String hash = String.valueOf(temp);
            if (map.containsKey(hash)) {
                lists.get(map.get(hash)).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
                map.put(hash,index);
                index++;
            }

        }
        return lists;
    }

    //空间优化：直接同<242.有效的字母异位词> 的套路，把字符的char转换的下标都+1 然后转换字符串作为key 存储，套路如上  优化的空间，时间会慢点

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        int[] count = new int[26];
        for (String s : strs) {

            Arrays.fill(count,0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String hash = Arrays.toString(count);

            if (map.containsKey(hash)) {
                lists.get(map.get(hash)).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                lists.add(list);
                map.put(hash,index);
                index++;
            }

        }
        return lists;
    }

    //官方优化(不咋喜欢)：采用一个char(不是字符) 来加密字符串, ，而且我在官方跑这个的时候，暴力解法是15ms，这个官方的是54ms
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        int[] count = new int[26];
        for (String s : strs) {

            Arrays.fill(count,0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String hash = Arrays.toString(count);

            if (map.containsKey(hash)) {
                lists.get(map.get(hash)).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                lists.add(list);
                map.put(hash,index);
                index++;
            }

        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_49_693().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new LeetCode_49_693().groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new LeetCode_49_693().groupAnagrams3(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
