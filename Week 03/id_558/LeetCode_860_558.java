package Week03;

/**
 * @Date 2019/11/2.
 * @see <a href="860">https://leetcode-cn.com/problems/lemonade-change/description/</a>
 * 柠檬水找零
 */
public class LeetCode_860_558 {
    /**
     * 思维：
     * 1、贪心算法只考虑当前步骤
     * 2、分类
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) return false;
                five--;
                ten++;
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
