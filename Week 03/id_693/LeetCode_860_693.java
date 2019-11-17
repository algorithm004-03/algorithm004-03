package id_693;

/**
 * @Desc 322. 零钱兑换  https://leetcode-cn.com/problems/coin-change/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/02
 */
public class LeetCode_860_693 {
    //第一次解法，效率很低3秒。再反复看题和题解，发现我不用考虑多个，
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int money = bills[i];
            if (money == 5) {
                five++;
                continue;
            }
            if (money == 10 || money == 20) {
                if (money == 10) {
                    ten++;
                }
                int index = (money - 5) / 10;
                if (index != 0) {
                    if (ten >= index) {
                        money = money - index * 10;
                        ten -= index;
                    } else {
                        money = money - ten * 10;
                        ten -= ten;
                    }
                }
                index = (money - 5) / 5;
                if (index != 0) {
                    if (five >= index) {
                        money = money - index * 5;
                        five -= index;
                    } else {
                        money = money - five * 5;
                        five -= five;
                    }
                }
                if (money != 5) {
                    return false;
                }
            }
        }
        return true;
    }

    //根据题解进行优化
    public boolean lemonadeChange2(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int money = bills[i];
            if (money == 5) {
                five++;
            } else if (money == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (money == 20) {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else {
                    if (ten == 0 && five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //浏览国际站代码净化,但是国际站是用的foreach  java中数组遍历推荐用for。更高效
    public boolean lemonadeChange3(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_860_693().lemonadeChange2(new int[]{5, 5, 5, 10, 20}));
        System.out.println(new LeetCode_860_693().lemonadeChange2(new int[]{5, 5, 10}));
        System.out.println(new LeetCode_860_693().lemonadeChange2(new int[]{10, 10}));
        System.out.println(new LeetCode_860_693().lemonadeChange2(new int[]{5, 5, 10, 10, 20}));
        System.out.println(new LeetCode_860_693().lemonadeChange2(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
    }
}

