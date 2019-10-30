package week2;

/**
 * @program: leetcode
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @author: 王瑞全
 * @create: 2019-10-2811:26
 **/


public class leetcode50_2_468 {
    public double myPow(double x, int n) {
         if(n==0){
             return 1;
         }
         if(n<0){
             n=-n;
             x=1/x;
         }

         return n%2==0?myPow(x*x,n/2):myPow(x*x,n/2)*x;
    }
}
