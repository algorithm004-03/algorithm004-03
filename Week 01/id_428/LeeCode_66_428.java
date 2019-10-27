class Solution {
    public int[] plusOne(int[] digits) {
        int currentRemainder = 0, lastRemainder = 1;
        for (int i = digits.length -1 ; i >= 0; i--) {
            currentRemainder = (digits[i] + lastRemainder) / 10;
            digits[i] = (digits[i] + lastRemainder) % 10;
            lastRemainder = currentRemainder;
        }
        if (lastRemainder > 0) {
            int[] result = new int[digits.length + 1] ;
            result[0] = lastRemainder;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}