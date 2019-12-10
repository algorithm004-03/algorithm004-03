package study;

/**
 * 
 * @desc: 就是按照中间线将首尾的数组元素进行调换。
 * @dete: 20191208
 *
 */
public class LeeCode_344_108 {

	public void reverseString(char[] s) {

		if (s == null || s.length <= 1) {
			return;
		}

		int len = s.length - 1;
		int mid = len / 2;

		char tmp;
		int last;
		for (int i = 0; i <= mid; i++) {
			last = len - i;
			tmp = s[i];
			s[i] = s[last];
			s[last] = tmp;
		}
		for (int i = 0; i < s.length; i++)
			System.out.print(s[i]);

	}

	public static void main(String[] args) {
		LeeCode_344_108 test = new LeeCode_344_108();
		char[] s = new char[] { 'h', 'e', 'l', 'l', 'o' };
		test.reverseString(s);

	}
}
