import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * @author L
 *
 */
public class LeetCode_70_138 {
	
	/**
	 * 递归求解爬楼梯-n最多45,不加缓存会导致超时
	 * @param n
	 * @return
	 */
	 private Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	    public int climbStairs(int n) {
	        if(n<=2) {
	            map.put(n,n);
				return n;
			}
	        int n_1 = 0;
	        if(map.containsKey(n-1)){
	            n_1 = map.get(n-1);
	        }else{
	            n_1 = climbStairs(n-1);
	            map.put(n-1,n_1);
	        }
	        int n_2 = 0;
	        if(map.containsKey(n-2)){
	            n_2 = map.get(n-2);
	        }else{
	            n_2 = climbStairs(n-2);
	            map.put(n-2,n_2);
	        }
	        
			return n_1+n_2;
	    }
	    
	    /**
	     * 非递归方法
	     * @param n
	     * @return
	     */
	    public int climbStairs2(int n) {
	    	if(n<=2)
	    		return n;
	    	int i =3;
	    	int sum=0,one = 1,two = 2;
	    	while(i++<=n) {
	    		sum = two+one;
	    		one = two;
	    		two = sum;
	    	}
	    	return sum;
	    }
	
	
}
