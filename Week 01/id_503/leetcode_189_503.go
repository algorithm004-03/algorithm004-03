package week01

// 循环替换法
func rotate(nums []int, k int) {
	n := len(nums)
	if k >= n {
		k = k % n
		if k == 0 { // 表示数组右移动了 x * n (x > 0) 次，相当于不移动
			return
		}
	}

	for i, count := 0, 0; count < n; i++ {
		curr := i
		prev := nums[curr]
		for {
			next := (curr + k) % n
			temp := nums[next]
			nums[next] = prev
			prev = temp

			curr = next
			count++

			if curr == i {
				break
			}
		}
	}
}
