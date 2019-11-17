//455. 分发饼干

//解法1：双指针
public int findContentChildren(int[] g, int[] s) {
	Arrays.sort(g);
	Arrays.sort(s);
	int sum = 0;
	int i = 0;
	int j = 0;
	while (i < s.length && j < g.length) {
		if (s[i] >= g[j]) {
			i++;
			j++;
			sum++;
		} else {
			i++;
		}
	}
	return sum;
}