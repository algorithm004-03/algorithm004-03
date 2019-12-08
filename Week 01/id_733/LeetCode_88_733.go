func merge(nums1 []int, m int, nums2 []int, n int) {
	i, j, idx := m-1, n-1, len(nums1)-1;
	for i >= 0 && j >= 0 {
		if nums1[i] < nums2[j] {
			nums1[idx] = nums2[j]
			j--
		} else {
			nums1[idx] = nums1[i]
			i--
		}

		idx--
	}

	for j >= 0 {
		nums1[idx] = nums2[j]
		j--
		idx--
	}
}
