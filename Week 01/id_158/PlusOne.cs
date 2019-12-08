// [66] 加一
public class Solution {
    public int[] PlusOne(int[] digits) {
        for (int i = digits.Length-1; i >=0; i--)
        {
            digits[i]++;
            if(digits[i]<10) {
                return digits;
            } else{
                digits[i]=0;
            }
        }
        if(digits[0]!=0){
            return digits;
        }
        int[] res = new int[digits.Length+1];
        res[0] = 1;
        for (int i = 0; i < digits.Length; i++)
        {
            res[i+1] = digits[i];
        }
        return res;
    }
}