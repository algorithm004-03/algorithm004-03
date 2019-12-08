package id313

// 通过 m+n 可以确定数组最终长度，对两个数组从后到前遍历，比较大小 放到相应位置。考虑好边界问题
func merge(nums1 []int, m int, nums2 []int, n int) {
	p1 := m - 1
	p2 := n - 1
	for p := m + n - 1; p >= 0; p-- {
		if p1 < 0 {
			nums1[p] = nums2[p2]
			p2--
			continue
		}

		if p2 < 0 {
			nums1[p] = nums1[p1]
			p1--
			continue
		}
		if nums2[p2] > nums1[p1] {
			nums1[p] = nums2[p2]
			p2--
		} else {
			nums1[p] = nums1[p1]
			nums1[p1] = nums2[p2]
			p1--
		}
	}
}
