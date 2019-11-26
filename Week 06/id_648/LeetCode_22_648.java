import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/11/24 21:49
 **/
public class LeetCode_22_648 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,"",0,0,n);
        return ans;
    }
    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        if(cur.length()==2*max){
            ans.add(cur);
            return;
        }
        if(open<max){
            backtrack(ans,cur+"(",open+1,close,max);
        }
        if(open<close){
            backtrack(ans,cur+")",open,close+1,max);
        }

    }
}
