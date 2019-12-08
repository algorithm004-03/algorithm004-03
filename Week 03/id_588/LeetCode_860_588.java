/**
 * 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LeetCode_860_588 {

    public boolean lemonadeChange(int[] bills) {
        if (null == bills) {
            return false;
        }

        // 如果第一个付款的人给的不是5美元，则肯定不能找零成功，因为一开始手头没有任何零钱
        if (5 != bills[0]) {
            return false;
        }

        int num5 = 1;
        int num10 = 0;
        // 从第二个人开始遍历
        for (int i = 1; i < bills.length; i ++) {
            // 如果付款是5美元，则不用找零，让5美元计数加一
            if (5 == bills[i]) {
                num5 ++;
            } else if (10 == bills[i]) {
                // 如果付款是10美元，则只能找5美元，让5美元计数减一
                num10 ++;
                if (num5 > 0) {
                    num5 --;
                } else {
                    return false;
                }
            } else {
                // 如果付款是20美元，则找零10+5或者5+5+5
                if (num10 >= 1 && num5 >= 1) {
                    num5 --;
                    num10 --;
                } else if (num5 >= 3) {
                    num5 = num5 - 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode_860_588 solution = new LeetCode_860_588();
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 5, 5, 5}));
        System.out.println(solution.lemonadeChange(new int[]{10, 5, 5, 5, 5}));
        System.out.println(solution.lemonadeChange(new int[]{5, 10, 5, 5, 5, 20}));
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
