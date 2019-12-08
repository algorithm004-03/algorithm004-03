package week3;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机 II
 * @author: 王瑞全
 * @create: 2019-11-0320:33
 **/


public class leetcode122_3_468 {
    public int maxProfit(int[] prices) {
            int count=0;
           for(int i=0;i<prices.length-1;i++){
               if(prices[i]<prices[i+1]){
                   count+=prices[i+1]-prices[i];
               }
           }
           return count;
    }
}
