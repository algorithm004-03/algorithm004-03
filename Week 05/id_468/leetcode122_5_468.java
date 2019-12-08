package week4;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机 II
 * @author: 王瑞全
 * @create: 2019-11-1822:57
 **/


public class leetcode122_5_468 {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max+=prices[i]-prices[i-1];
            }
        }
        return max;
    }
}
