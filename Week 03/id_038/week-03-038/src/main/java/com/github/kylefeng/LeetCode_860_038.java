package com.github.kylefeng;

/**
 * 860. 柠檬水找零
 *
 * @author kylefeng
 * @time 2019/11/1 17:49
 */
public class LeetCode_860_038 {


    public static boolean lemonadeChange(int[] bills) {
        // 5 美元的数量
        int $5 = 0;
        // 10 美元数量
        int $10 = 0;

        for (int i = 0; i < bills.length; i++) {
            int buck = bills[i];

            // 5 美元，不需要找零
            if (buck == 5) {
                $5++;
                continue;
            }

            // 10 美元，必须要有至少一个 5 美元
            // 10 美元数增加，5 美元数减少
            if (buck == 10 && $5 > 0) {
                $10++;
                $5--;
                continue;
            }

            // 20 美元，要么 $5 + $10
            // 要么找 3个 $5
            if (buck == 20) {
                if ($5 > 0 && $10 > 0) {
                    $5--;
                    $10--;
                    continue;
                }

                if ($5 >= 3 && $10 == 0) {
                    $5--;
                    $5--;
                    $5--;
                    continue;
                }
            }

            // 找不开
            return false;
        }

        return true;
    }
}
