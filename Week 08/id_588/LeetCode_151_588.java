/**
 * 反转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/%E2%80%A8/
 */
public class LeetCode_151_588 {

    // 先split
    // 再从后往前添加各个单词（去除空格字符串或者空字符串）
    public String reverseWords(String s) {
        if (null == s) {
            return null;
        }

        String[] splitArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splitArr.length - 1; i >= 0; i--) {
            String str = splitArr[i];
            // 去掉空格
            while (str.contains(" ")){
                str = str.replaceAll(" ","");
            }
            if ("".equals(str)){
                continue;
            }
            sb.append(str);
            if (0 != i){
                sb.append(" ");
            }
        }
        return sb.toString();
    }


}
