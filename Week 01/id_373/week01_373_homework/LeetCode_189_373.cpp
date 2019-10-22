class Solution {
public:
    void rotate(vector<int>& nums, int k) {
	k = k % nums.size();
	int count = 0;
	for(int i = 0; count < nums.size(); i++)
	{
		int current = i;
		int prev = nums[i];
		do 
		{
			int next = (current + k) % nums.size();
			int temp = nums[next];
			nums[next] = prev;
			prev = temp;
			current = next;
			count++;
		} while(i != current);
	}
        
    }
};