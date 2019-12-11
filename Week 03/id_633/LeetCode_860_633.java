package lesson10;

public class LeetCode_860_633 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (5 == bill) {
                five++;
            } else if (10 == bill) {
                if (0 == five) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
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
