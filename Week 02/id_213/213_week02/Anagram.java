public class Solution{

//这个题目解法颇多。
//思路1.可将字符串转为字符数组，然后排序。最后使用数组的比较方法即可求得。

    public boolean isAnagram(String s,String t) {
        char[] c = s.toCharArray();
        char[] c1 = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c1);
        return Arrays.equals(c,c1);
        
    }
//思路2.使用字符串的ASC值做下标，记录26个字母出现的次数，两者相同返回true,否则返回false。
    public boolean isAnagram2(String s, String t) {
       int[] counter = new int[26];
       for (int i = 0; i < s.length; i++) {
           counter[s.charAt[i] - 'a']++;
           counter[t.charAt[i] - 'a']--;
       }
       for(int count : counter) {
           if(count !=0) return false;
       }
       return true;
    } 

}