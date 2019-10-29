//
//  RotateArray.swift
//  AlgorithmStudy


//189.旋转数组
import Foundation

class Solution {
    //方法1.取余数
    func rotate(_ nums: inout [Int], _ k: Int) {
        let terns = k % nums.count
        if nums.isEmpty || terns == 0 {
            return
        }
        var newNums = nums
        for i in 0..<nums.count {
            newNums[(i + terns) % nums.count] = nums[i]
        }
        nums = newNums
    }
    //方法2.先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下
    func rotateA(_ nums: inout [Int], _ k: Int) {
        let terns = k % nums.count
        if nums.isEmpty || terns == 0 {
            return
        }
        let middle = nums.count - terns
        
        reverse(&nums, s: 0, e: middle - 1)
        reverse(&nums, s: middle, e: nums.count - 1)
        reverse(&nums, s: 0, e: nums.count - 1)
    }
    
    func reverse(_ nums: inout [Int], s: Int, e: Int) {
        var s = s
        var e = e
        while s < e {
            let temp = nums[s]
            nums[s] = nums[e]
            nums[e] = temp
            
            s += 1
            e -= 1
        }
    }
}


