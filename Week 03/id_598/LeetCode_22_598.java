import java.util.ArrayList;
import java.util.List;

/**
 * @author northleaf
 * @create 2019年10月31日
 */
public class LeetCode_22_598 {
    /**
     * 递归法生成括号
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(0,0,n,"",list);
        return list;
    }

    /**
     * 递归生成
     * @param left
     * @param n
     * @param s
     * @param list
     */
    private void helper(int left,int right, int n, String s, List<String> list) {
        //终止条件
        //左右括号的数量与给定的括号对数一致的时候就是退出的时候
        if(left == n && right==n){
            list.add(s);
            return;
        }


        //处理当前层
        //当左括号数小于括号对数的时候要添加左括号
        if(left < n ){
            helper(left+1,right,n,s+"(",list);
        }
        if(right < left){
            helper(left,right+1,n,s+")",list);
        }

        //下一层
        //与当前层的处理合并了
        //清理数据
    }
}
