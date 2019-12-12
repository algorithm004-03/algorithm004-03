package id_338;

/**
 * @author Leesen
 * @date 2019/12/8 23:10
 */
public class LeetCode_14_338 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i=0; i<strs[0].length(); i++) {  //以第一个字符串做对比基准
            for (int j=1; j<strs.length; j++) {  //循环后面每个字符串的每个字符跟基准比较
                if (strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
