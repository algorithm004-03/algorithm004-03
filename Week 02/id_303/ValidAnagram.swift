//
//  ValidAnagram.swift
//  AlgorithmStudy

import Foundation

//242有效的字母异位词题解
func isAnagram(_ s: String, _ t: String) -> Bool {
    //创建一个含有26个为0的值的数组
    var sArr = Array<Int>(repeating: 0, count: 26)
    for character in s.unicodeScalars {
        let index = Int(character.value - 97)
        //记录字符出现的次数
        sArr[index] = sArr[index] + 1
    }
    //创建一个含有26个为0的值的数组
    var tArr = Array<Int>(repeating: 0, count: 26)
    for character in t.unicodeScalars {
        let index = Int(character.value - 97)
        //记录字符出现的次数
        tArr[index] = tArr[index] + 1
    }
    return sArr == tArr
}
