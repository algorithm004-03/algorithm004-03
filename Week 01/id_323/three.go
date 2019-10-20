func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := [][]int{}
	var(
		i int
		r int
		l int
	)
	var length int = len(nums)
	
	for i = 0; i < length; i++ {
		if (nums[i]>0) {
			continue
		}
		if (i>0 && nums[i] == nums[i-1]) {
			continue
		}
		l = length-1;
		for r = i+1; r < l;{
			if (l<length-1 && nums[l] == nums[l+1]) {
				l--
				continue
			}
			if (r>i+1 && nums[r] == nums[r-1]) {
				r++
				continue
			}
			sum := nums[i]+nums[r]+nums[l]
			if (sum > 0) {
				l--
			}
			if (sum < 0) {
				r++
			}
			if (sum == 0) {
				arr := []int{nums[i],nums[r],nums[l]}
				res = append(res,arr)
				l--;r++;
			}
		}
	}
	return res
}
