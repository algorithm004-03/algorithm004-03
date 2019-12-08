//
//  ValidSudoku.swift
//  AlgorithmStudy

import Foundation

func isValidSudoku(_ board: [[Character]]) -> Bool {
    var rowDict: [Int:[Character:Int]] = [:]
    var columnDict: [Int:[Character:Int]] = [:]
    var boxDict: [Int:[Character:Int]] = [:]
    for i in (0..<9) {
        for j in (0..<9) {
            let c = board[i][j]
            if c == "." {
                continue
            }
            if rowDict[i] == nil {
                rowDict[i] = [:]
            }
            if rowDict[i]![c] != nil {
                return false
            }else{
                rowDict[i]![c] = 1
            }
            
            if columnDict[j] == nil {
                columnDict[j] = [:]
            }
            if columnDict[j]![c] != nil {
                return false
            }else{
                columnDict[j]![c] = 1
            }

            let bIndex = i / 3 * 3 + j / 3
            if boxDict[bIndex] == nil {
                boxDict[bIndex] = [:]
            }
            if boxDict[bIndex]![c] != nil {
                return false
            }else {
                boxDict[bIndex]![c] = 1
            }
        }
    }
    return true
}
