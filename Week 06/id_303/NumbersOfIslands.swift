//
//  NumbersOfIslands.swift
//  AlgorithmStudy

import Foundation

func numIslands(_ grid: [[Character]]) -> Int {
    var map = grid
    let row = map.count
    if row == 0 {return 0}
    let col = map[0].count
    var count = 0
    for i in 0..<row {
        for j in 0..<col {
            if map[i][j] == "1" {
                dfs(&map, i, j, row, col)
                count += 1
            }
        }
    }
    return count
}
func dfs(_ map: inout [[Character]], _ i: Int, _ j: Int, _ row: Int, _ col: Int) {
    if (i >= 0 && i < row && j >= 0 && j < col && map[i][j] == "1") {
        map[i][j] = "2"
        dfs(&map, i, j-1, row, col);
        dfs(&map, i-1, j, row, col);
        dfs(&map, i, j+1, row, col);
        dfs(&map, i+1, j, row, col);
    }
}
