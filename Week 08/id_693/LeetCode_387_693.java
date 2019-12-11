package id_693;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 李雷（KyLin）
 * @Desc 387. 字符串中的第一个唯一字符	https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @Date 2019/12/04
 */
public class LeetCode_387_693 {
    /**
     * hash表去重保存  时间复杂度O(2N)  空间复杂度O(N)
     */
    class Solution {
        public int firstUniqChar(String s) {
            int len = s.length();
            Map<Character, Integer> map = new HashMap<>(len,1);
            for (int i = 0; i < len; i++) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            }
            for (int i = 0; i < len; i++) {
                if (map.get(s.charAt(i)) == 1) return i;
            }
            return -1;
        }
    }

    /**
     * 使用String的内置函数 substring和indexOf     时间复杂度 O(N^2)  空间O(1)
     */
    class Solution2 {
        public int firstUniqChar(String s) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                String temp = s.substring(0,i);
                String temp1 = s.substring(i + 1);
                if (temp.indexOf(s.charAt(i)) == -1 && temp1.indexOf(s.charAt(i)) == -1) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 针对第二种解法 取消内置函数，时间复杂度 O(N * (N - 1))
     */
    class Solution3 {
        public int firstUniqChar(String s) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                boolean f = true;
                for (int j = 0; j < i; j++) {
                    if (!f || s.charAt(i) == s.charAt(j)) {
                        f = false;
                        break;
                    }
                }
                for (int j = i + 1; j < s.length(); j++) {
                    if (!f || s.charAt(i) == s.charAt(j)) {
                        f = false;
                        break;
                    }
                }
                if (f) return i;
            }
            return -1;
        }

    }

    /**
     * 直接使用String的内置函数，因为indexOf 是从前开始查找，而lastIndexOf 从后面找，只需要看两个是否一样即可，一样则只有一次
     */
    class Solution4 {
        public int firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                int dex = s.indexOf(s.charAt(i));
                if (s.lastIndexOf(s.charAt(i)) == dex) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 利用只有小写字母，直接写死，这样时间复杂度就是 indexOf 最坏是O（N） 不用加上 lastIndexOf ，因为出现需要这个的时候，说明前面已经找到了， 所以最后的时间复杂度是O（N）
     */
    class Solution5 {
        public int firstUniqChar(String s) {
            int res = Integer.MAX_VALUE;
            for (char i = 'a'; i <= 'z'; i++) {
                int index = s.indexOf(i);
                if (index != -1 && s.lastIndexOf(i) == index) {
                   res = Math.min(index,res);
                }
            }
            return res == Integer.MAX_VALUE ? -1 :res;
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().firstUniqChar("leetcode"));
    }

    @Test
    public void test2() {
        System.out.println(new Solution5().firstUniqChar("cc"));
        System.out.println(new Solution5().firstUniqChar("leetcode"));
        System.out.println(new Solution5().firstUniqChar("loveleetcode"));
    }
}
