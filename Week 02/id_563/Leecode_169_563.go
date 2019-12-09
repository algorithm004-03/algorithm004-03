/**
* 用sort的话非常巧妙好记，而且看了下复杂度还可以
*/

func majorityElement(nums []int) int {
    sort.Ints(nums)
    return nums[len(nums)/2]
}
