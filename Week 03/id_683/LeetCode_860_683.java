import java.util.Arrays;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null) {
            return true;
        }

        int fiveDoller = 0, tenDoller = 0;
        for (int i = 0; i < bills.length; ++i) {
            if (bills[i] == 5) fiveDoller++;
            else if (bills[i] == 10) {
                if (fiveDoller > 0) {
                    fiveDoller--;
                    tenDoller++;
                } else {
                    return false;
                }
            } else if (bills[i] > 10) {
                if (fiveDoller > 0 && tenDoller > 0) {
                    fiveDoller--;
                    tenDoller--;
                } else if (fiveDoller >= 3) {
                    fiveDoller -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}