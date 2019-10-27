/*
 * @lc app=leetcode.cn id=78 lang=golang
 *
 * [78] 子集
 */
 
// @lc code=start
package leetCode

func subsets(nums []int) [][]int {
	ret := [][]int{}
	if nums == nil || len(nums) == 0 {
		return ret
	}
	dfs(&ret, nums, []int{}, 0)
	return ret
}

func dfs(ret *[][]int, nums []int, arr []int, index int) {
	if len(nums) == index {
		*ret = append(*ret, arr)
		return
	}
	dfs(ret, nums, arr, index+1)
	arr = append(arr, nums[index])
	dfs(ret, nums, arr, index+1)
	arr = arr[:0]
}

// @lc code=end
