//选择排序

//思路：将序列分为有序区与无序区, 遍历无序区, 选择一个最小的元素放入有序区末尾
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public int[] select(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		int min = 0;
		for (int j = i; j < arr.length; j++) {
			min = arr[j] < arr[min] ? j : min;
		}
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	return arr;
}