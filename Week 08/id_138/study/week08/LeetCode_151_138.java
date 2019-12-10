package study.week08;

/**
 * 翻转字符串里的单词
 * @author Lukas
 * @since 2019/12/8 20:01
 **/
public class LeetCode_151_138 {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=words.length-1;i>=0;i--){
            if (!words[i].equals("")) {
                sb.append(words[i]).append(" ");
            }
        }
        String temp = sb.toString().trim();
        return temp;
    }
}
