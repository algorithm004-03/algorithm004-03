//交换排序：冒泡排序

//思路：遍历N次, 每一次将当前序列中最大的元素冒泡到序列末尾
//时间复杂度：O(N^2)
//空间复杂度：O(1)
public int[] bubble(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr.length - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
			}
		}
	}
	return arr;
}