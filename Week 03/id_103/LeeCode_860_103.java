package com.homework.week3;

public class LeeCode_860_103 {

    public boolean lemonadeChange(int[] bills) {
        int count_money[] = {0, 0, 0}; //其中，从前往后分别表示5，10，20的数量。
        for (int bill : bills) {
            if (bill == 5) {
                count_money[0] += 1;
            } else if (bill == 10 && count_money[0] != 0) {
                count_money[0] -= 1;
                count_money[1] += 1;
            } else if (bill == 10 && count_money[0] == 0) {
                return false;
            } else if (bill == 20 && count_money[1] != 0 && count_money[0] != 0) {
                count_money[0] -= 1;
                count_money[1] -= 1;
                count_money[2] += 1;
            } else if (bill == 20 && count_money[0] >= 3) {
                count_money[0] -= 3;
                count_money[2] += 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
