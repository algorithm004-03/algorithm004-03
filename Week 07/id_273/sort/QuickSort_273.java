//快速排序

//思路：将序列根据一个"基准"划分为左右两块区域, 左边都小于等于该基准, 右边都大于该基准, 分别递归对左右两个区域进行重复操作, 直到整个序列有序
//时间复杂度：O(nlog2N)
//空间复杂度：O(1)
public void quickSort(int[] array, int begin, int end) {
	if (begin >= end) return;
	int ref = partition(array, begin, end);//基准
	quickSort(array, begin, ref - 1);
	quickSort(array, ref + 1, end);
}

//根据基准划分为左右两块区域 : 这里基准选取序列的末尾元素
private int partition(int[] array, int begin, int end) {
	int count = begin;
	for (int i = begin; i < end; i++) {
		if (array[i] <= array[end]) {
			int temp = array[i]; array[i] = array[count]; array[count] = temp;
			count++;
		}
		int temp = array[count]; array[count] = array[end]; array[end] = temp;
	}
	return count;
}