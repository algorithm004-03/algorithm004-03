/**
 * @program: leetcode
 * @description: Plus One
 * @author: 王瑞全
 * @create: 2019-10-2018:40
 **/


public class leetcode66_1_468 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            else {
                digits[i]=0;
            }
        }
        if(digits[0]==0){
            digits=new int[digits.length+1];
            digits[0]=1;
        }
        return digits;
    }
}
