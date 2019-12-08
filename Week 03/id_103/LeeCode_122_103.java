package com.homework.week3;

public class LeeCode_122_103 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int i = 0;
        int maxProfit = 0;
        int less;
        int more;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            less = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            more = prices[i];
            maxProfit += more - less;
        }
        return maxProfit;
    }
}
