//插入排序

//思路：将序列分为有序区和无序区, 遍历无序区的所有元素, 将其插入到有序区的正确位置
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public int[] insert(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
		for (int j = i; j > 0; j--) {
			if (arr[j] < arr[j - 1]) {
				int temp = arr[j]; arr[j] = arr[j - 1]; arr[j - 1] = temp;
			}
		}
	}
	return arr;
}