package id_713.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 */
public class LeetCode_771_JewelsAndStones {
    /*
     给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

    示例 1:

    输入: J = "aA", S = "aAAbbbb"
    输出: 3

    示例 2:

    输入: J = "z", S = "ZZ"
    输出: 0


    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/jewels-and-stones
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    */

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();

        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int res = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c))
                res++;
        }
        return res;
    }

    public int numJewelsInStones2(String J, String S) {
       int res = 0;
       for (char s : S.toCharArray()) {
           if(J.indexOf(s) != -1)
               res++;
       }

       return res;
    }

}
