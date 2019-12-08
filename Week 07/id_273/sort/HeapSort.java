//堆排序

//思路：根据序列构建大顶堆, 将序列首部的最大元素移动到无序区末尾
public void heapSort(int arr[]) {
	for (int i = arr.length - 1; i > 0; i--) {
		maxHeap(arr, i);//最大元素移动到首部
		int temp = arr[0];
		arr[0] = arr[i];
		arr[i] = temp;
	}
}

private void maxHeap(int arr[], int n) {
	for (int i = (n - 1)/2; i >= 0; i--) {
		int child = i * 2 + 1;
		if (child != n && arr[child] < arr[child + 1]) {
			child++;
		}
		if (arr[child] > arr[i]) {
			int temp = arr[child]; arr[child] = arr[i]; arr[i] = temp;
		}
	}
}