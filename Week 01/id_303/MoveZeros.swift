//
//  ReverseLinkedList.swift
//  AlgorithmStudy
//
//  Created by 张奇 on 2019/10/20.
//  Copyright © 2019 张奇. All rights reserved.
//

//
import Foundation
class MoveZerosSolution {
    func moveZeroes(_ nums: inout [Int]) {
        let count = nums.count
        var j = 0
        for i in 0..<count {
            if nums[i] != 0 {
                nums.swapAt(i, j)
                j += 1
            }
        }
    }
}

