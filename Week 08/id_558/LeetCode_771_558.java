package Week07;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @see <a href="771">https://leetcode-cn.com/problems/jewels-and-stones/</a>
 * 宝石与石头
 */
public class LeetCode_771_558 {

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), 0);
        }

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }

        }
        int sum = 0;
        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            sum += map.get(iterator.next());
        }
        return sum;
    }

    public static void main(String[] args) {

    }


}
