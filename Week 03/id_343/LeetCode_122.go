func maxProfit(prices []int) int {
    var i, ret int
    for i < len(prices)-1 {
        if prices[i+1] > prices[i] {
            ret += (prices[i+1] - prices[i])
        }
        i++
    }
    return ret
}
