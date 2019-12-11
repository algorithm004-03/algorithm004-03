import java.util.HashMap;

/**
 * @Date 2019/12/8
 **/
public class LeetCode_387_648 {

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int num =0;
        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            boolean flag=false;
            for(int j=i+1;j<s.length();j++){
                char s2 = s.charAt(j);
                if(s1 == s2){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                num = i;
                break;
            }
        }
        return num;
    }
    public int firstUniqChar2(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int num =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_387_648 leetCode_387_648 = new LeetCode_387_648();
        String str = "loveleetcode";
        int num = leetCode_387_648.firstUniqChar2(str);
        System.out.println(num);
    }
}
