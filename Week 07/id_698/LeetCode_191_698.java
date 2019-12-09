/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 
 * @author gning (id=698)
 */

public class LeetCode_191_698 {

    public int hammingWeight(int n) {
        int count = 0;

        while(n!=0) {
            count ++;
            n &= (n-1);
        }

        return count;

    }


}