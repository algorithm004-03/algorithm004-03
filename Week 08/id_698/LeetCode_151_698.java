/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * @author gning (id=698)
 */

public class LeetCode_151_698 {
    public String reverseWords(String s) {
        final String space = " ";
        final String[] words = s.trim().split(space);

        StringBuffer buf = new StringBuffer();

        for(int i=words.length-1; i>=0; i--) {
            String word = words[i];

            if(word.isEmpty()) {
                continue;
            }

            buf.append(word.replace(space, ""));

            if(i>0)
                buf.append(space);
        }

        return buf.toString();
    }
}