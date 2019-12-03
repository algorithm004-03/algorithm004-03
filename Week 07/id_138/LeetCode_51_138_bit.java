/**
 * N皇后
 * @author L
 *
 */
public class LeetCode_51_138_bit {

	private int size ,count;
	
	public int queenCount(int n) {
		count = 0;
		size = (1 << n)-1;// 1*2^n -1
		solve(0,0,0);//可以放皇后的位置
		return count;
	}

	private void solve(int row, int ld, int rd) {
		// TODO Auto-generated method stub
		if(row == size)
		{
			count++;
			return;
		}
		int pos = size &(~(row|ld|rd));
		while(pos!=0) {
			int p = pos &(-pos);
			pos -= p;
			solve(row|p,(ld|p)<<1,(rd|p)>>1);
		}
	}
	
	public static void main(String[] args) {
		LeetCode_51_138_bit lb = new LeetCode_51_138_bit();
		System.out.println(lb.queenCount(4));
	}
}
