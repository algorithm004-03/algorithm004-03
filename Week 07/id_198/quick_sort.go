package leetcode

func QuickSort(array []int, begin, end int) {

	if end <= begin {

		return
	}

	pivot := partition(array, begin, end)
	QuickSort(array, begin, pivot-1)
	QuickSort(array, pivot+1, end)
}

func partition(array []int, begin, end int) int {

	counter := begin
	pivot := end
	for i := begin; i < end; i++ {

		if array[i] < array[pivot] {
			array[counter], array[i] = array[i], array[counter]
			counter++
		}
	}
	array[counter], array[pivot] = array[pivot], array[counter]
	return counter
}
