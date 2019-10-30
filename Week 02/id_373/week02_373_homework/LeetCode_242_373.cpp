#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
using namespace std;

//242. 有效的字母异位词
/*
明确问题中的点：
（1）大小写是否敏感
*/

/*
错误的思路：
（1）开始想以为把两个字符串的ascii值对比，后来发现不对，如：ac, bb
bool isAnagram(string s, string t)
{
	if (s.length() != t.length())
		return false;

	int sCount = 0;
	int tCount = 0;
	for (int i = 0; i < s.length(); i++)
	{
		sCount += s.at(i);
		tCount += t.at(i);
	}
	if (sCount == tCount)
		return true;
	else
		return false;
}
*/

/*
解题思路一：暴力枚举
时间复杂度：O(n^2)
方法：第一次用暴力枚举的时候，没有想到如果第二个字符串中重复出现第一个字符串中的某个字符的情况，然后出错，如："aacc", "ccac"。
*/
#if 0
bool isAnagram(string s, string t)
{
	if (s.length() != t.length())
		return false;

	for (int i = 0; i < s.length(); i++)
	{
		for (int j = 0; j < t.length(); j++)
		{
			if (s.at(i) == t.at(j))
			{
				t.replace(j, 1, "");
				break;
			}
			else
			{
				if (j == t.length() - 1)
					return false;

				continue;
			}
		}
	}

	return true;
}
#endif

/*
解题思路二：暴力枚举
时间复杂度：O(nlogn)
方法：给两个字符串sort一遍，然后比较sort后的结果。
*/
#if 0
bool isAnagram(string s, string t)
{
	sort(s.begin(), s.end());
	sort(t.begin(), t.end());

	cout << s << endl;;
	cout << s.size() << endl;
	cout << t << endl;
	cout << t.size() << endl;

	if (!s.compare(t)) return true;
	
	return false;
}
#endif

/*
解题思路三：hash映射
时间复杂度：O(n)
方法：在s中出现的字符一定在t中出现，比较每个字符在各自字符串中出现的次数
	 new一个26个int元素的数组，每个数组元素记录对应字符出现的次数，最
     后两个数组相减操作，如果有一个数组元素的差不为零，就不是anagram字符串。
*/
#if 0
bool isAnagram(string s, string t)
{
	if (s.length() != t.length()) {
		return false;
	}
	int counter[26] = {0};
	for (int i = 0; i < s.length(); i++) {
		counter[s.at(i) - 'a']++;
		counter[t.at(i) - 'a']--;
	}
	for (int count : counter) {
		if (count != 0) {
			return false;
		}
	}
	return true;
}
#endif

bool isAnagram(string s, string t)
{
	if (s.length() != t.length()) 
		return false;

	int counter[26] = {0};
	for (int i = 0; i < s.length(); i++)
	{
		counter[s.at(i) - 'a']++;
	}
	for (int i = 0; i < t.length(); i++)
	{
		int count = counter[t.at(i) - 'a']--;
		if(count < 0)
			return false;
	}

	return true;
}


/*
int main()
{
	string s, t;
	s = "anagram";
	t = "nagaram";
	//isAnagram(s, t);

	if (isAnagram(s, t))
		printf("yes");
	else
		printf("no");

	while (1);

	return 0;
}
*/

