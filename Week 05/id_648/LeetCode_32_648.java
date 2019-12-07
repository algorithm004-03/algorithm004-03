import java.util.HashMap;
import java.util.Stack;

/**
 * @Date 2019/11/17
 **/
public class LeetCode_32_648 {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char subStr = s.charAt(i);
            if(subStr =='('){
                stack.push(subStr);
            }else if(!stack.isEmpty() && stack.peek() =='('){
                stack.pop();
            } else {
               return false;
            }
        }
        return stack.isEmpty();
    }


    public int longestValidParentheses(String s) {
        int maxLen = 0 ;
        for(int i=0;i<s.length();i++){
          for(int j=i+2;j<=s.length();j++){
              if(isValid(s.substring(i,j))){
                  maxLen = Math.max(maxLen,j-i);
              }
          }
        }
        return maxLen;
    }
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int maxlen = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-1]+2:0)+2;
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i] = dp[i-1] +((i-dp[i-1])>2 ? dp[i-dp[i-1]-2]:0)+2;
                }
                maxlen = Math.max(maxlen,dp[i]);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LeetCode_32_648 leetCode_32_648 = new LeetCode_32_648();
        String s=")()())";
        System.out.println(leetCode_32_648.longestValidParentheses2(s));
    }
}
