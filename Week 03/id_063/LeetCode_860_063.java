/*
贪心策略
每次找钱尽量把面值大的给出去即可
 */

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0;
        int tenCnt = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCnt++; continue;
            }

            if (bills[i] == 10) {
                if (fiveCnt == 0) {
                    return false;
                }

                fiveCnt--; tenCnt++; continue;
            }

            if ((fiveCnt >= 1) && (tenCnt >= 1)) {
                fiveCnt--; tenCnt--; continue;
            }

            if (fiveCnt >= 3) {
                fiveCnt -= 3; continue;
            }

            return false;
        }
        return true;
    }
}
