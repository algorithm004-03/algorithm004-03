import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = null;

        if (digits[len-1] != 9) {
            result = Arrays.copyOf(digits, len);
            result[len-1]++;
        } else {
            Queue<Integer> q = new LinkedList<>();
            int carry = 0;
            int sum;

            sum = digits[len-1] + 1;
            carry = (sum >= 10) ? 1 : 0;
            q.add(sum % 10);

            for (int i = len-2; i >= 0; i--) {
                sum = digits[i] + carry;
                carry = (sum >= 10) ? 1 : 0;
                q.add(sum % 10);
            }

            if (carry != 0) {
                q.add(carry);
            }

            result = new int[q.size()];
            for (int i = result.length-1; i >= 0; i--) {
                result[i] = q.poll();
            }
        }

        return result;
    }
}