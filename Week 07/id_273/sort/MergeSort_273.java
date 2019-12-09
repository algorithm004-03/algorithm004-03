//归并排序

//思路：将序列折半, 对左边和右边的序列分别进行排序后合并 
public void mergeSort(int[] array, int left, int right) {
	if (left >= right) return;
	int mid = (left + right) >> 1;
	mergeSort(array, left, mid);
	mergeSort(array, mid + 1, right);
	merge(array, left, mid, right);
}

private void merge(int[] array, int left, int mid, int right) {
	int[] temp = new int[right - left + 1];
	int i = left, j = mid + 1, k = 0;
	while (i <= mid && j <= right) {
		temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
	}
	while (i <= mid) temp[k++] = array[i++];
	while (j <= right) temp[k++] = array[j++];
	System.arraycopy(temp, 0, array, left, temp.length);
}