class Solution {
    fun search(nums: IntArray?, target: Int): Int {
        if (nums == null) {
            return -1
        }

        if (nums.isEmpty()) {
            return -1
        }

        var size = nums?.size
        var left = 0
        var right = size-1
//        if (nums.contains())
//        var pivot = 0
        if (nums.size==1) {
            if (nums[0]==target) {
                return 0
            } else {
                return -1
            }
        }
        var pivot = binararySearch(nums,left,right)

        if (nums[pivot]==target) {
            return pivot
        }

        if (pivot==0) {
            return binararySearchTarget(nums,pivot,right,target)
        }

        return if (target<nums[0]) {
            binararySearchTarget(nums,pivot,right,target)
        } else {
            binararySearchTarget(nums,left,pivot,target)
        }

    }

    fun binararySearch(nums: IntArray?, l: Int, r: Int): Int {

        if(nums!![l]<nums!![r]) {
            return 0
        }
        var pivot = -1
        var left = l
        var right = r

        while (left <= right) {
            pivot = (left + right) / 2
            if (nums!![pivot] > nums!![pivot+1]) {
                return pivot+1
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1
                } else {
                    left = pivot + 1

                }
            }
        }

        return pivot
    }



    fun binararySearchTarget(nums: IntArray?, left: Int, right: Int, target: Int): Int {

        var left = left
        var right = right
        while (left <= right) {

            var pivot = (left + right) / 2
            if (nums!![pivot] ==target) {

                return pivot
            } else {
                if (nums[pivot] > target) {
                    right = pivot - 1
                } else {
                    left = pivot + 1

                }
            }
        }

        return -1
    }
}