package week3;

/**
 * @program: leetcode
 * @description: 有效的平方数
 * @author: 王瑞全
 * @create: 2019-11-0322:47
 **/


public class leetcode367_3_468 {
    public boolean isPerfectSquare(int num) {
       int low=1,hight=num;
       while(low<=hight){
           long mid=(low+hight)>>>1;
           if(mid*mid==num){
               return true;
           }else if(mid*mid<num){
               low=(int)mid+1;
           }else{
               hight=(int)mid-1;
           }
       }
       return false;
    }
}
