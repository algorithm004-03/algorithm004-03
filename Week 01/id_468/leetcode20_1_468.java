import java.util.Stack;

/**
 * @program: leetcode
 * @description: Vaild Parentheses
 * @author: 王瑞全
 * @create: 2019-10-1818:47
 **/


public class leetcode20_1_468 {
    public boolean isValid(String s) {
        Stack<Character> test=new Stack<>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='{'){
                test.push('}');
            }
            else if(chars[i]=='['){
                test.push(']');

            }
            else if(chars[i]=='('){
                test.push(')');

            }
            else if(test.isEmpty()||test.pop()!=chars[i]){
                return false;
            }
        }
        return test.isEmpty();

    }
}
