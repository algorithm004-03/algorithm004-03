/*

思路
简单字符串处理

 */

class Solution {
    private boolean isValid(char ch) {
        return ch == '-' || ch == '+' || (ch >= '0' && ch <= '9');
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i == str.length() || !isValid(str.charAt(i))) {
            return 0;
        }

        boolean negative = str.charAt(i) == '-';
        long val = (str.charAt(i) >= '0' && str.charAt(i) <= '9') ? str.charAt(i)-'0' : 0;
        if (negative) val *= -1;
        i++;

        int[] buf = new int[str.length()];
        int cnt = 0;
        while (i < str.length()) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }

            buf[cnt++] = str.charAt(i) - '0';
            i++;
        }

        for (i = 0 ; i < cnt; i++) {
            val = val *10 + (negative ? -1 * buf[i] : buf[i]);
            if (negative && val < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (!negative && val > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int)(val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("         3.14"));
    }
}