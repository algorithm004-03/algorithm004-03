
package leetcode

//leetcode submit region begin(Prohibit modification and deletion)
func removeDuplicates(nums []int) int {
	i := 0
	for j := 0; j < len(nums); j++ {

		if nums[i] != nums[j] {

			i++
		}
		nums[i] = nums[j]
	}
	return i + 1

}

//leetcode submit region end(Prohibit modification and deletion)
