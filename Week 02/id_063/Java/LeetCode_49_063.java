/*
思路
把每一个字符串映射成一个统计字符频率和所有字符个数的结构，用该结构作为Map的key,Map的值
为容纳相同的key的字符串的List，迭代每一个字符串，更新Map结构，最后把Map中所有的Value全
放到结果的List中去即可
 */


import java.util.*;


class Solution {
    private class KeyNode implements Comparable<KeyNode> {
        int[] cnt;
        int totalCharNum;

        public KeyNode(int[] cnt, int totalCharNum) {
            this.cnt = cnt;
            this.totalCharNum = totalCharNum;
        }

        @Override
        public int compareTo(KeyNode o) {
            if (totalCharNum < o.totalCharNum) {
                return -1;
            } else if (totalCharNum > o.totalCharNum) {
                return 1;
            }

            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != o.cnt[i]) {
                    return cnt[i] - o.cnt[i];
                }
            }

            return 0;
        }
    }

    private KeyNode string2KeyNode(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        return new KeyNode(arr, str.length());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<KeyNode, List<String>> map = new TreeMap<>();

        for (String str : strs) {
            KeyNode key = string2KeyNode(str);
            if (!map.containsKey(key)) {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
            }
        }

        return new LinkedList<>(map.values());
    }
}
