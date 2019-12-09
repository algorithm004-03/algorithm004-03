package test1.week_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/27.
 */
public class Leetcode_242_638 {

    /**
     * 异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<String,Integer> map = new HashMap<String, Integer>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char elm:sArr){
            Integer count = map.get(String.valueOf(elm)) == null ? 0 : map.get(String.valueOf(elm));
            map.put(String.valueOf(elm),++count);
        }
        int zero = 0;
        for (char elm:tArr){
            Integer count = map.get(String.valueOf(elm));
            if(count == null){
                return false;
            }else {
                map.put(String.valueOf(elm),--count);
                if (count == 0){
                    zero ++;
                }
            }
        }
        return zero == map.size();
    }
}
