func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return nil
	}

	quickSort(intervals)
	res := make([][]int, 1)
	res[0] = intervals[0]
	last := res[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= last[1] {
			if intervals[i][1] > last[1] {
				last[1] = intervals[i][1]
			}
		} else {
			res = append(res, intervals[i])
			last = intervals[i]
		}
	}

	return res
}

func quickSort(intervals [][]int) {
	if len(intervals) <= 1 {
		return
	}

	pivot := partition(intervals)
	quickSort(intervals[:pivot])
	quickSort(intervals[pivot+1:])
}

func partition(intervals [][]int) int {
	idx, pivot := 0, len(intervals)-1
	for i := 0; i < pivot; i++ {
		if intervals[i][0] < intervals[pivot][0] {
			intervals[idx], intervals[i] = intervals[i], intervals[idx]
			idx++
		}
	}

	intervals[idx], intervals[pivot] = intervals[pivot], intervals[idx]
	return idx
}
