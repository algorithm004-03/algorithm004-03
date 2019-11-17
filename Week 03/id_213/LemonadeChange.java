//思路：(1)当出现十元面值时，只能用五元，如果没有，返回false。
//      (2)当出现20元时，优先使用十元加上一张五元的组合，如果没有十元，用三张五元替换，
//      如果没有返回false;
//      (3)当遍历完数组，则返回true;
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
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

