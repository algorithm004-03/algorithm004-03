/*
242有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。


示例?
1:

输入: s = "anagram", t = "nagaram"

输出: true
示例 
2:

输入: s = "rat", t = "car"

输出: false


*/


class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++) {
        	if(map.containsKey(s.charAt(i)))
        		map.put(s.charAt(i), map.get(s.charAt(i))+1);
        	else 
        		map.put(s.charAt(i), 1); 
        }
        for(int j=0;j<t.length();j++) {
        	if(map.containsKey(t.charAt(j))) {
        		map.put(t.charAt(j), map.get(t.charAt(j))-1);
        		if(map.get(t.charAt(j))==0) 
        			map.remove(t.charAt(j), map.get(t.charAt(j)));
            }else
                return false;
        }
        return map.isEmpty();
    }
}