func moveZeroes(nums []int)  {
	var j int;
    j = 0;
    for i:=0;i<len(nums);i++ {
        if(nums[i] != 0) {
             nums[j] = nums[i]
            if(j != i) {
                nums[j] = nums[i]
                nums[i] = 0
            }
            j++
        }
	}
}
