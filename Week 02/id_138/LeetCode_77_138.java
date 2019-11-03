import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author L
 *
 */
public class LeetCode_77_138 {
	private List<List<Integer>> result = new ArrayList();
	public List<List<Integer>> combine(int n, int k) {
        if(n<0 || k<0 || n<k) {
        	return result;
        }
        Stack<Integer> stack = new Stack();
        //从1到n开始，第一个元素是1
		combineHelper(n,k,1,stack);
        
		return result;
    }
	private void combineHelper(int n, int k, int start, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.size() == k) {//从n个元素已经收集元素的个数=k
			result.add(new ArrayList<Integer>(stack));
			return;
		}
		for(int i=start;i<=n;i++) {//从start开始继续收集元素
			stack.add(i);
			combineHelper(n, k, i+1, stack);
			stack.pop();//最后加入的一个元素已经找不到符合的结果了
		}
	}
	
	
}
