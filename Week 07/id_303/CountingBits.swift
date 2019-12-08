//
//  CountingBits.swift

import Foundation


func countBits(_ num: Int) -> [Int] {
    guard num > 0 else {
        return [0]
    }
    
    var result = [0]
    var i = 0
    var total = 1
    
    for j in 1...num {
        result.append(result[i] + 1)
        i += 1
        if i == total {
            i = 0
            total = j + 1
        }
    }
    return result
}
