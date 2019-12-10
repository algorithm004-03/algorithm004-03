package id_338;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Leesen
 * @date 2019/12/8 23:10
 */
public class LeetCode_151_338 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" +");  //****先trim一下去两端空格,  split(" +")
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }
}
