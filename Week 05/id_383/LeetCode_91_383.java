public class LeetCode_91_383 {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < len; i++) {
            int tmp = curr;
            int currNum = s.charAt(i);
            int lastNum = s.charAt(i - 1);
            if (currNum == '0') {
                if (lastNum == '1' || lastNum == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (lastNum == '1' || lastNum == '2' && currNum >= '1' && currNum <= '6') {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }
}
