//
//  RelativeSortArray.swift

import Foundation


func relativeSortArray(_ arr1: [Int], _ arr2: [Int]) -> [Int] {
  var dict = [Int: Int]()
  var result = [Int]()
  for a in arr1 {
    dict[a] = (dict[a] ?? 0)+1
  }

  for a in arr2 {
    if let val = dict[a] {
      for i in 0..<val {
        result.append(a)
      }
      dict.removeValue(forKey: a)
    }
  }
  var simpleArray = [Int]()
  if !dict.isEmpty {
    for (key,val) in dict {
      for i in 0..<val {
        simpleArray.append(key)
      }
      dict.removeValue(forKey: key)
    }
  }
  result.append(contentsOf: simpleArray.sorted())
  return result
}
