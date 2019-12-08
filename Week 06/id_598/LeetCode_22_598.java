import java.util.ArrayList;
import java.util.List;

/**
 * @author northleaf
 * @create 2019年11月21日
 */
public class LeetCode_22_598 {

    /**
     * 递归的方式处理
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        heler(0,0,n,"",ans);
        return ans;
    }

    private void heler(int left, int right,  int n,String s, List<String> ans) {
       if(left ==n && right == n){
           ans.add(s);
       }

       if(left<n){
           heler(left+1,right,n,s+"(",ans);
       }
       if(right<left){
           heler(left,right+1,n,s+")",ans);
       }


    }
}
