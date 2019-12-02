#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
#include <list>
#include <sstream>
using namespace std;

//49. 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

//这类题的解题关键是：某一个字符串中的某一个字母出现的频率与其他字符串的对应字母的出现频率相同，
//仅仅是位置不同罢了，所以我们的方法是可以忽略位置，仅仅计算每个字符出现的频率数

/*
解题思路一：使用map，sort方法
时间复杂度：O(Knlogn) K代表字符串长度
方法：使用map把每一个sort后的string当做key，遍历数组，如果下一个字符串的sort后的结果在map的key中已经存在，
	 则加入到list中去，如果不存在的话，则生成一个新的key。
*/
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs) 
{
	map<string, vector<string>> strMap;
	vector<vector<string>> resultVec;

	if (0 == strs.size())
		return resultVec;
	//vector<string> strSrc = strs; //由于sort函数的返回值是void，所有copy了一份src vector。改进方法使用临时变量就不用copy一份。
	for (int i = 0; i < strs.size(); i++)
	{
		string temp = strs[i];
		sort(strs[i].begin(), strs[i].end());

		if(strMap.find(strs[i]) == strMap.end())
		{
			strMap[strs[i]] = vector<string>();
		} 

		strMap[strs[i]].push_back(temp);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	/*map<string, vector<string>>::iterator strMap_iter = strMap.begin();
	for (; strMap_iter != strMap.end(); strMap_iter++)
	{
		resultVec.push_back(strMap_iter->second);
	}*/

	return resultVec;
}
#endif

//上面代码的替换版本
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs) {

	map<string, vector<string>> strMap;
	vector<vector<string>> resultVec;

	if (0 == strs.size())
		return resultVec;

	for (int i = 0; i < strs.size(); i++)
	{
		string temp = strs[i];
		sort(strs[i].begin(), strs[i].end());

		strMap[strs[i]].push_back(temp);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	return resultVec;

}
#endif

//leetcode 上参考
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs)
{
	map<string, vector<string> > ma;
	vector<vector<string>> res;
	for (auto str : strs)
	{
		string tmp = str;
		sort(tmp.begin(), tmp.end());
		ma[tmp].push_back(str);
	}
	for (const auto& m : ma)
		res.push_back(m.second);
	return res;
}
#endif

/*
解题思路二：使用map方法
时间复杂度：O(Kn) K代表字符串长度
方法：统计每个字符在每个字符串中出现的频率组成26个字母的数组count，然后把count转换成string作为map的可以，然后遍历vector，
	 下一个字符串的count string出现在map现有的key中，就把他加到链表里，否则则生成新的key。
*/
#if 1
vector<vector<string>> groupAnagrams(vector<string>& strs)
{
	vector<vector<string>> resultVec;
	map<string, vector<string>> strMap;
	if (0 == strs.size())
		return resultVec;
	
	for (string item : strs)
	{
		stringstream s;
		int count[26] = { 0 };
		for (int i = 0; i < item.length(); i++)
		{
			count[item.at(i) - 'a'] ++;
		}

		for (int i = 0; i < 26; i++)
		{
			s << count[i];
		}

		/*
		if (strMap.find(s.str()) == strMap.end())
			strMap[s.str()] = vector<string>();
		*/

		strMap[s.str()].push_back(item);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	/*
	map<string, vector<string>>::iterator map_iter = strMap.begin();
	for (; map_iter != strMap.end(); map_iter++)
	{
		resultVec.push_back(map_iter->second);
	}
	*/

	return resultVec;
}
#endif

/*
int main()
{

	string strs[6] = {"are","bat", "ear", "code", "tab", "era"};
	vector<string> strV;
	cout << strs->size() << endl;
	for (int i = 0; i < 6; i++)
	{
		strV.push_back(strs[i]);
	}
	cout << strV.size() << endl;

	vector<vector<string>> result = groupAnagrams(strV);

	while (1);
	return 0;
}
*/