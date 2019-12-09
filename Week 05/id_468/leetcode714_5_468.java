package week4;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机含手续费
 * @author: 王瑞全
 * @create: 2019-11-1823:40
 **/


public class leetcode714_5_468 {
    public int maxProfit(int[] prices, int fee) {
        if(prices==null|prices.length<2){
            return 0;
        }
        int cost=Integer.MIN_VALUE,pro=0;
        for(int price:prices){
            cost=Math.max(cost,pro-price-fee);
            pro=Math.max(pro,price+cost);
        }
        return pro;
    }
}
