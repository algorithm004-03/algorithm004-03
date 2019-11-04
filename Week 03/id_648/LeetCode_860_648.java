/**
 * 柠檬水找零
 */
public class LeetCode_860_648 {
    public boolean lemonadeChange(int[] bills) {
       int five =0;
       int ten = 0;
       for(int i=0;i<bills.length;i++){
           if(bills[i]==5){
               five++;
           }else if(bills[i]==10){
               if(five==0){
                   return false;
               }
               five--;
               ten++;
           }else {
               if(five>0&&ten>0){
                   five--;
                   ten--;
               }else if(five>2){
                   five-=3;
               }else {
                   return false;
               }
           }
       }
       return true;
    }

    public static void main(String[] args) {
        LeetCode_860_648 leetCode_860_648 = new LeetCode_860_648();
        int[] bills = new int[]{5,10,5,20,5,10,5,20};
        boolean flag = leetCode_860_648.lemonadeChange(bills);
        System.out.println(flag);
    }
}
