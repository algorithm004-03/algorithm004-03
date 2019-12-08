package week7;

/**
 * @program: leetcode
 * @description: 位1的个数
 * @author: 王瑞全
 * @create: 2019-12-0121:01
 **/


public class leetcode191_7_468 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count=0;
       while (n!=0){
           count+=n&1;
           n>>>=1;
       }
       return count;
    }
}
