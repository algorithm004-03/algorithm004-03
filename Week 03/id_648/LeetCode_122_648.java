/**
 *买卖股票的最佳时机
 */
public class LeetCode_122_648 {
    public int maxProfit(int[] prices) {
        int i=0;
        int total =0;
        int peak = prices[0];
        int valley = prices[0];
        while(i<prices.length-1) {
            while (i<prices.length-1&&prices[i+1]<=prices[i]){
                i++;
            }
            valley = prices[i];
            while (i<prices.length-1&&prices[i+1]>=prices[i]){
                i++;
            }
            peak = prices[i];
            total+=peak-valley;
        }

        return total;
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int total =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                total+=prices[i]-prices[i-1];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        LeetCode_122_648 leetCode_122_648 = new LeetCode_122_648();
        int[] prices = new int[]{7,1,5,3,6,4};
        int total = leetCode_122_648.maxProfit(prices);
        System.out.println(total);
    }

}
