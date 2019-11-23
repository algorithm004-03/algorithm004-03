package id_713;

/**
 * 860. 柠檬水找零
 */
public class LemonadeChange {

    /*
    思路:
    模拟真实场景即可
    注意, 客户只会使用 5, 10, 20
     */

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (Integer i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                if (five == 0) return false;
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }



}