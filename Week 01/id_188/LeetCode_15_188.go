import "sort"

/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
func threeSum(nums []int) [][]int {
	ret := make([][]int, 0, 10)

	if len(nums) < 3 {
		return ret
	}

	sort.Ints(nums)

	for index, value := range nums {
		if index > len(nums)-2 || value > 0 || (value+nums[index+1]) > 0 {
			break
		}

		if index > 0 && value == nums[index-1] {
			continue
		}

		leftIndex, rightIndex := index+1, len(nums)-1

		for leftIndex < rightIndex {
			if leftIndex > index+1 && nums[leftIndex] == nums[index+1] {
				leftIndex++
				continue
			}

			if rightIndex < len(nums)-1 && nums[rightIndex] == nums[rightIndex+1] {
				rightIndex--
				continue
			}

			v := value + nums[leftIndex] + nums[rightIndex]

			if v < 0 {
				leftIndex++
			} else if v > 0 {
				rightIndex--
			} else {
				ret = append(ret, []int{value, nums[leftIndex], nums[rightIndex]})
				leftIndex++
				rightIndex--
			}
		}
	}
	return ret
}

// @lc code=end
