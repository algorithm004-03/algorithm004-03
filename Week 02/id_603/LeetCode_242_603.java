public class LeetCode_242_603 {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
//        System.out.println(s.charAt(1));
        int [] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a'] +=1;
            counter[t.charAt(i)-'a'] -=1;
        }
        for (int i :counter){
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
