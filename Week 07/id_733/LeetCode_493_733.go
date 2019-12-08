func reversePairs(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	cnt := 0
	mid := len(nums) >> 1
	cnt += reversePairs(nums[:mid]) + reversePairs(nums[mid:])

	newNums := make([]int, len(nums))
	i, idx, k := 0, 0, 0
	for j := mid; j < len(nums); j++ {
		for idx < mid && float64(nums[idx])/2 <= float64(nums[j]) {
			idx++
		}

		for i < mid && nums[i] <= nums[j] {
			newNums[k] = nums[i]
			i++
			k++
		}

		cnt += mid - idx
		newNums[k] = nums[j]
		k++
	}

	for i < mid {
		newNums[k] = nums[i]
		i++
		k++
	}

	copy(nums, newNums)
	return cnt
}

func reversePairsV2(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	numsCopy := make([]int, len(nums))
	copy(numsCopy, nums)
	sort.Ints(numsCopy)

	cnt := 0
	bit := NewBIT(len(nums))
	for i := len(nums) - 1; i >= 0; i-- {
		cnt += bit.Search(index(numsCopy, float64(nums[i])/2))
		bit.Insert(index(numsCopy, float64(nums[i])) + 1)
	}

	return cnt
}

func index(nums []int, num float64) int {
	start, end := 0, len(nums)-1
	for start <= end {
		mid := start + (end-start)>>1
		val := float64(nums[mid])
		if val >= num {
			end = mid - 1
		} else {
			start = mid + 1
		}
	}

	return start
}

type BIT struct {
	arr []int
}

func NewBIT(cap int) *BIT {
	b := &BIT{}
	b.arr = make([]int, cap+1)
	return b
}

func (b *BIT) Insert(idx int) {
	for idx < len(b.arr) {
		b.arr[idx]++
		idx += idx & (-idx)
	}
}

func (b *BIT) Search(idx int) int {
	sum := 0
	for idx > 0 {
		sum += b.arr[idx]
		idx -= idx & (-idx)
	}

	return sum
}
