import java.util.Arrays;
import java.util.Collections;

/**
 * @Date 2019/12/8
 **/
public class LeetCode_151_648 {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        Collections.reverse(Arrays.asList(arr));
        StringBuffer sb = new StringBuffer();
        for(String str:arr){
            sb.append(str +" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LeetCode_151_648 leetCode_151_648 = new LeetCode_151_648();
        String str = "  hello world!  ";
        String reverseStr = leetCode_151_648.reverseWords(str);
        System.out.println(reverseStr);
    }
}
