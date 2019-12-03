package week3;

/**
 * @program: leetcode
 * @description: 柠檬水找零
 * @author: 王瑞全
 * @create: 2019-11-0320:20
 **/


public class leetcode860_3_468 {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i:bills){
            if(i==5)five++;
            else if(i==10){five--;ten++;}
            else if(ten>0){ten--;five--;}
            else five-=3;
            if(five<0)return false;
        }
         return true;
    }
}
