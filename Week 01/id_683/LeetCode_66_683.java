class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int carry = 0;

        for (int i = digits.length - 1; i >= 0; --i) {
            int d = i == digits.length - 1 ? digits[i] + 1 + carry : digits[i] + carry;
            carry = d / 10;
            digits[i] = d % 10;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; ++i) {
                result[i] = digits[i - 1];
            }
            return result;
        }

        return digits;
    }
}