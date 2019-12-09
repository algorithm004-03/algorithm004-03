//
//  PhoneNumber.swift
//  AlgorithmStudy


import Foundation

//17.电话号码的字母组合
var dictionary: [Character: [Character]] = [
        "2": ["a", "b", "c"],
        "3": ["d", "e", "f"],
        "4": ["g", "h", "i"],
        "5": ["j", "k", "l"],
        "6": ["m", "n", "o"],
        "7": ["p", "q", "r", "s"],
        "8": ["t", "u", "v"],
        "9": ["w", "x", "y", "z"]
    ]
var results = [String]()

func letterCombinations(_ digits: String) -> [String] {
    let array = digits.map { dictionary[$0] ?? [] }
    let counts = array.map({$0.count})
    if counts.contains(0) || counts.isEmpty {
        return []
    }
    var flags = [Int](repeating: 0, count: array.count)
    var temperate = ""
    var answers = [String]()
    var affectedFields = [Int]()
    loop: while true {
        if temperate.isEmpty {
            for j in 0..<flags.count {
                temperate.append(array[j][flags[j]])
            }
        } else {
            for i in affectedFields {
                temperate.replaceSubrange(temperate.index(temperate.startIndex, offsetBy: i)..<temperate.index(temperate.startIndex, offsetBy: i + 1), with: String(array[i][flags[i]]))
            }
            affectedFields.removeAll()
        }
        answers.append(temperate)
        var j = flags.count - 1
        while true {
            flags[j] += 1
            affectedFields.append(j)
            if flags[j] < counts[j] {
                break
            } else {
                flags[j] = 0
                j -= 1
                if j < 0 {
                    break loop
                }
            }
            
        }
        
    }
    return answers
}

/*
 func letterCombinations(_ digits: String) -> [String] {
     if digits.count == 0 {
         return []
     }
     var result: [String] = []
     let letter = ["2" : ["a","b","c"], "3" : ["d","e","f"], "4" : ["g","h","i"], "5" : ["j","k","l"], "6" : ["m","n","o"], "7" : ["p","q","r","s"], "8" : ["t","u","v"], "9" : ["w","x","y","z"]]
     for a in digits {
         let le = letter[String(a)]!
         if result.count == 0 {
             result = le
             continue
         }
         let res = result
         result = []
         for l in le {
             for r in res {
                 result.append(r+l)
             }
         }
     }
     return result
 }
*/
