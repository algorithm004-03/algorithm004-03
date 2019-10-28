//
//  PreorderTraversal.swift
//  AlgorithmStudy


import Foundation

//144.二叉树的前序遍历
func preorderTraversal(_ root: TreeNode?) -> [Int] {
    guard let root = root else { return [] }
    var stack = [root]
    var processed = [Int]()
    while let node = stack.popLast() {
        processed.append(node.val)
        if let right = node.right {
            stack.append(right)
        }

        if let left = node.left {
            stack.append(left)
        }
    }
    return processed
}
