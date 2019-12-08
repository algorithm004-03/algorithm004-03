//1122. 数组的相对排序

//解法1：暴力解法
//思路：遍历arr2, 找到arr1中与arr2[i]相等的元素, 并存入res数组, 
//		arr1中判断过的元素置为-1, 然后将剩下arr1中不为-1的值依次添加到res末尾然后对这部分进行排序
//时间复杂度：O(m*n)
public int[] relativeSortArray(int[] arr1, int[] arr2) {
	int[] res = new int[arr1.length];
	int k = 0;
	int count = 0;
	for (int i = 0; i < arr2.length; i++) {
		for (int j = 0; j < arr1.length; j++) {
			if (arr1[j] == arr2[i]) {
				res[k++] = arr1[j];
				arr1[j] = -1;
				count++;
			}
		}
	}
	for (int j = 0; j < arr1.length; j++) {
		if (arr1[j] != -1) res[k++] = arr1[j];
	}
	Arrays.sort(res, count, res.length);
	return res;
}

//解法2：计数法
//思路：由题可知arr1和arr2的范围在0 ~ 1000, 因此创建一个1001大小的数组用于存储arr1出现的次数
//		然后遍历arr2, 观察arr2[i]这个值在计数数组中出现了多少次, 并按该次数赋值给arr1, 到目前为止, 按arr2的相对排序就完成了
//		剩下的一些未出现在arr2中的值, 只需要在计数数组中寻找不为0的元素, 并依次添加到arr1尾部即可。
//时间复杂度：O(1)
//空间复杂度：O(1) 常数的数组大小
public int[] relativeSortArray(int[] arr1, int[] arr2) {
	int[] temp = new int[1001];
	int k = 0;
	for (int i : arr1) {
		temp[i]++;
	}
	for (int j : arr2) {
		while (temp[j]-- > 0) arr1[k++] = j;
	}
	for (int i = 0; i < temp.length; i++) {
		while (temp[i]-- > 0) arr1[k++] = i;
	}
	return arr1;
}

//解法2.1：计数法TreeMap实现
//思路：如果不限制arr1和arr2的范围, 那么我们可以用基于红黑树的TreeMap对arr1出现的次数进行统计
//时间复杂度：O(n * log2N)
//空间复杂度：O(n)
//总结：TreeMap存储的是一个有序的集合, 若未通过比较器指定, 集合内元素默认自然排序
public int[] relativeSortArray3(int[] arr1, int[] arr2) {
	TreeMap<Integer, Integer> map = new TreeMap<>();
	int k = 0;
	for (int i : arr1) {
		map.put(i, map.getOrDefault(i, 0) + 1);
	}
	for (int i : arr2) {
		while (map.get(i) != 0) {
			arr1[k++] = i;
			map.put(i, map.get(i) - 1);
		}
	}
	for (int i : map.keySet()) {
		while (map.get(i) != 0) {
			arr1[k++] = i;
			map.put(i, map.get(i) - 1);
		}
	}
	return arr1;
}