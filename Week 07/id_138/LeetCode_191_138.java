/**
 * 位1的个数
 * 输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数
 * @author L
 *
 */
public class LeetCode_191_138 {

	int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {    // 4 100
			n = n & n - 1;  // 3 011
							// & 0
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LeetCode_191_138 l138 = new LeetCode_191_138();
		int x = l138.hammingWeight(4);
		System.out.println(x);
	}
}
