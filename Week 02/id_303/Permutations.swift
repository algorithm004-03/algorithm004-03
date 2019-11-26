//
//  Permutations.swift
//  AlgorithmStudy


import Foundation
//46.全排列
func permute(_ nums: [Int]) -> [[Int]] {
    var array = nums
    var result = [[Int]]()
    helper(&array,0,&result)
    return result
}

func helper (_ arr: inout [Int], _ begin:Int, _ results: inout [[Int]]){
    if begin >= arr.count{
        results.append(arr)
        return
    } else {
        for i in begin..<arr.count{
        // choose
        arr.swapAt(begin, i)
        // explore
        helper(&arr, begin + 1, &results)
        // unchoose
        arr.swapAt(begin, i)
        }
    }
}
