package week4;

/**
 * @program: leetcode
 * @description: Best Time to Buy and Sell Stock
 * @author: 王瑞全
 * @create: 2019-11-1800:10
 **/


public class leetcode121_5_468 {
    public int maxProfit(int[] prices) {
        int diff=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            diff=Math.max(diff,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return  diff;
    }
}
