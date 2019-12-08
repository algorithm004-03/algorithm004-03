#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

//1. 两数之和
/*
解题思路一：暴力求解
时间复杂度：O(n^2)
方法：遍历数组，在数组中找到target-nums[i]的值
*/
#if 0
vector<int> twoSum(vector<int>& nums, int target)
{
	vector<int> result;
	for (int i = 0; i < nums.size(); i++)
	{
		for (int j = i + 1; j < nums.size(); j++)
		{
			if (nums[i] == target - nums[j])
			{
				result.push_back(i);
				result.push_back(j);
			}
		}
	}

	return result;
}
#endif

/*
解题思路二：两边遍历map解法， 把数组中的元素存为map的key，但是在c++中的map不是hash map，所以存在一个问题就是：当数组中的元素存在重复的时候就错了。
时间复杂度：O(n)
方法：遍历数组，在map中找是否有存在的key。
*/
#if 0
vector<int> twoSum(vector<int>& nums, int target)
{
	vector<int> result;
	map<int, int> tempMap;
	for (int i = 0; i < nums.size(); i++)
	{
		tempMap[nums[i]] = i;
	}

	for (int i = 0; i < nums.size(); i++)
	{
		if (tempMap.find(target - nums[i]) != tempMap.end() && tempMap[target - nums[i]] != i)
		{
			result.push_back(tempMap[target - nums[i]]);
		}
	}

	return result;
}
#endif

/*
解题思路三：一遍map 把数组中的元素存为map的key。
时间复杂度：O(n)
方法：遍历数组，在map中找是否有存在的key。
*/
vector<int> twoSum(vector<int>& nums, int target)
{
	unordered_map <int, int> m;
	vector <int> ret;

	for (int i = 0; i < nums.size(); i++)
	{
		if (m.find(target - nums[i]) != m.end())
		{
			ret.push_back(m[target - nums[i]]);
			ret.push_back(i);
			break;
		}
		m[nums[i]] = i;
	}
	return ret;
}

/*
int main()
{
	int value[4] = {2, 7, 2, 15};

	vector<int> nums;
	for (int i = 0; i < 4; i++)
		nums.push_back(value[i]);

	vector<int> result = twoSum(nums, 9);
	for (int item : result)
	{
		cout << item << endl;
	}

	while (1);

	return 0;
}
*/