package week2;

/**
 * @program: leetcode
 * @description: 爬楼梯
 * @author: 王瑞全
 * @create: 2019-10-2420:19
 **/


public class leetCode70_2_468 {
    public int climbStairs(int n) {
       if(n==1||n==0){
           return 1;
       }
       int total=climbStairs(n-1)+climbStairs(n-2);
       return total;
    }
    public int climbStairs1(int n) {
        if(n==1||n==0){
            return n;
        }
        int count1=1;
        int count2=1;
        for(int i=2;i<=n;i++){
            int temp=count2;
            count2=count2+count1;
            count1=temp;
        }
        return count2;

    }
}
