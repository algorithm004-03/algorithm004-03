func rotate(nums []int, k int) {
	if len(nums) <= 1 || k <= 0 {
		return
	}

	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		res[(i + k) % len(nums)] = nums[i]
	}

	for i := 0; i < len(nums); i++ {
		nums[i] = res[i]
	}
}

func rotateV2(nums []int, k int)  {
	if len(nums) <= 1 || k <= 0 {
		return
	}

	for i, cnt := 0, 0; cnt < len(nums); i++ {
		idx := i
		val := nums[idx]
		for {
			next := (idx + k) % len(nums)
			nums[next], val = val, nums[next]
			cnt++
			if next == i {
				break
			}

			idx = next
		}
	}
}

func rotateV3(nums []int, k int) {


	if len(nums) <= 1 || k <= 0 {
		return
	}

	k = k % len(nums)
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])
}

func reverse(nums []int) {
	start, end := 0, len(nums)-1
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}