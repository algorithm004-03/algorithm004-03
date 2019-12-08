int maxProfit(vector<int>& prices) {
	int totalProfite = 0;
	for (size_t i = 1; i < prices.size(); i++)
	{
		if (prices[i - 1] < prices[i])
			totalProfite += (prices[i]-prices[i-1]);
	}
	return totalProfite;
}
