class Solution
{
public:
	vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2)
	{
		int a_size = arr1.size(), b_size = arr2.size();
		vector<int> Res, Left;

		map<int, int> m_a, m_b;
		for (int i = 0; i < a_size; i++)
			m_a[arr1[i]]++;

		for (int i = 0; i < b_size; i++)
			m_b[arr2[i]]++;


		for (int i = 0; i < b_size; i++)
			if (m_a.count(arr2[i]) != 0)
				for (int j = 0; j < m_a[arr2[i]]; j++)
					Res.push_back(arr2[i]);


		for (int i = 0; i < a_size; i++)
			if (m_b.count(arr1[i]) == 0)
				Left.push_back(arr1[i]);
		sort(Left.begin(), Left.end());


		for (int i = 0; i < Left.size(); i++)
			Res.push_back(Left[i]);

		return Res;
	}
};
