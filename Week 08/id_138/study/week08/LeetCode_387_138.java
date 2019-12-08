package study.week08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lukas
 * @since 2019/12/8 18:53
 **/
public class LeetCode_387_138 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {//初始化map，计算每个字符出现的次数
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
